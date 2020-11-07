package control;

import entity.Course;
import entity.Student;

import java.util.ArrayList;


public class StudentManager {
	
	CourseManager cmngr = new CourseManager();
	
	int currentIndexofStudent;
	ArrayList<Student> listofstudents = new ArrayList<Student>();
	
	public StudentManager(int global_i) {
		this.currentIndexofStudent = global_i;
		this.listofstudents = fileManager.loadStudentFile();	
	}
	
    public boolean addCourse(Course course, int tutGroup){
    	//make code to add course to current student 
    	
    	//load file function
	    		//ArrayList<String> listofstudentcurrentcourses = new ArrayList<String>();	
	    		//listofstudentcurrentcourses = listofstudents.get(this.currentIndexofStudent).getCourseEnrolled();
    		
    	//do your add course function
    			//listofstudentcurrentcourses.add();
    
    	
    	//end of add course function    	
		    	//listofstudents.get(this.currentIndexofStudent).setCourseEnrolled(listofstudentcurrentcourses);
		    	//fileManager.saveStudentFile(listofstudents);
		    	
    	
    	
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
