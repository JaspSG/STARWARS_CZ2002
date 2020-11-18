package control;

import entity.Course;
import entity.Index;
import entity.Student;

import java.util.ArrayList;
import java.util.Scanner;


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

    public boolean changeIndex(Course course, String index_id){
        Scanner sc = new Scanner(System.in);
        
        Student student = new Student();
        System.out.println("Printing list of course available for index change");
        for(int i = 0; i < student.getCourseEnrolled().size();i++)
        {
        	 System.out.println(student.getCourseEnrolled().get(i)+ "\n");
        }
        System.out.println("Enter the course that you want to change index:");
        String courseName = sc.nextLine(); 
        
        ArrayList<Course> list = student.getCourseEnrolled(); //student course
        
        FileManager fmgr = new FileManager();
        ArrayList<Course> courseList = FileManager.loadCoursesFile();
        
        ArrayList<Index> indexList = new ArrayList<Index>();
        
        int courseToChange = 0;
        for(int j =0; j < courseList.size();j++)
        {
        	if(courseName.equals(courseList.get(j).getCourseName()))
        	{
        		courseToChange = j;
        		indexList = courseList.get(j).getIndex();
        		break;
        	}
        }
        
        System.out.println("Printing list of index available for the course" + "\n");
        
        for (int k = 0; k < indexList.size(); k++)
        {
        	 System.out.println(indexList.get(k).getIndexID() + "\n");
        }
        System.out.println("Enter the index that you want to change to: ");
        String indexToChange = sc.nextLine();
        
        Index changeIndex = null;
        for(int l = 0; l <indexList.size(); l++)
        {
        	if(indexToChange.equals(indexList.get(l).getIndexID()))
        	{
        		changeIndex = indexList.get(l);
        		break;
        	}
        }
        
        //insert check for timeslot here
        
        ArrayList<Index> newIndex = null;
        newIndex.add(changeIndex);
        student.getCourseEnrolled().get(courseToChange).setIndex(newIndex);
 

        return true;
        
    }

    public boolean swapIndex(Course course, String index_id, Student student, int global_i){
    	Scanner sc = new Scanner(System.in);
        
        Student currentStud = new Student();
        System.out.println("Printing list of course available for index swap");
        for(int i = 0; i < currentStud.getCourseEnrolled().size();i++)
        {
        	 System.out.println(currentStud.getCourseEnrolled().get(i)+ "\n");
        }
        System.out.println("Enter the course that you want to swap index:");
        String courseName = sc.nextLine(); 
        
        ArrayList<Course> list = currentStud.getCourseEnrolled(); //student course
        
        FileManager fmgr = new FileManager();
        ArrayList<Course> courseList = FileManager.loadCoursesFile();
        
        ArrayList<Index> indexList = new ArrayList<Index>();
        
        Course courseToChange = null;
        for(int j =0; j < courseList.size();j++)
        {
        	if(courseName.equals(courseList.get(j).getCourseName()))
        	{
        		courseToChange = courseList.get(j);
        		indexList = courseList.get(j).getIndex();
        		break;
        	}
        }
        
        System.out.println("Enter name of student that you want to swap with: " + "\n");
        String studentName = sc.nextLine();
        
        ArrayList<Index> otherStudIndex;
        //check if student that he wants swap with has a same course to swap with
        ArrayList<Course> otherStudCourseList  = new ArrayList<Course>();
        for (int k = 0; k < listofstudents.size(); k++)
        {
        	 if(studentName.equals(listofstudents.get(k).getName()))
        	 {
        		 otherStudCourseList = listofstudents.get(k).getCourseEnrolled();
        		 for(int l = 0; l < otherStudCourseList.size();l++)
        		 {
        			 if(courseToChange.equals(otherStudCourseList.get(l)))
        			 {
        				 otherStudIndex = otherStudCourseList.get(l).getIndex();
        				 break;
        			 }
        		 }

        	 }
        }
        currentStud.getCourseEnrolled().get(index)
         
        
        //insert check for clash here
        
        
        
        
 
        return true; // temp value
    }

    public void removeFromWaitlist(){

    }

    public void addToWaitlist(){

    }
}
