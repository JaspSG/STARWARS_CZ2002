package control;

import entity.Course;
import entity.Student;

import java.util.ArrayList;


public class StudentManager {
	
	CourseManager cmngr = new CourseManager();
	int currentIndexOfStudent;
	ArrayList<Student> listofstudents = new ArrayList<Student>();
	
	public StudentManager(int global_i) {
		this.currentIndexofStudent = global_i;
		this.listofstudents = fileManager.loadStudentFile();	
	}

    public boolean addCourse(Course course, int tutGroup) throws Exception {
        //load file
        ArrayList<String> tempListOfCurrentCourse = new ArrayList<String>();
        tempListOfCurrentCourse = listofstudents.get(this.currentIndexOfStudent).getCourseEnrolled();

        //Check if course is already registered
        if(tempListOfCurrentCourse.contains(course.getCourseName())){
            System.out.println("Already enrolled in course!");
            return false;
        }
        //Check Schedule Clash
        //dosomething.something();
        //Check if there is slot,if no slots, add to waitlist instead, else:

        //do Add course name to Student Object
        tempListOfCurrentCourse.add(course.getCourseName());
        //Add student to Course Files
        Student tempStudent = listofstudents.get(this.currentIndexOfStudent);
        cmgr.addStudent(tempStudent,course,tutGroup);

        listofstudents.get(this.currentIndexOfStudent).setCourseEnrolled(tempListOfCurrentCourse);
        fileManager.saveStudentFile(listofstudents);

        return true; // temporary value
    }

    public boolean dropCourse(Course course, int tutGroup, int global_i){
        return false; // temporary value
    }

    public void printCourseRegistered(){
    }

    public boolean changeIndex(Course course, String index_id, int global_i){
        return true; // temporary value
    }

    public boolean swapIndex(Course course, String index_id, Student student, int global_i){
        return true; // temp value
    }

    public void removeFromWaitlist(){

    }

    public void addToWaitlist(){

    }
}
