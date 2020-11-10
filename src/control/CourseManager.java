package control;

import java.util.ArrayList;

import entity.Course;
import entity.Student;

public class CourseManager {
	
	ArrayList<Course> listOfCourses = new ArrayList<Course>();
	
	public CourseManager() {
		this.listOfCourses = fileManager.loadCoursesFile();
	}
	
	public boolean checkVacancy(String index_id) {
		return;
	}
	
	public boolean addStudent(Student tempStudent,Course course, String tutGroup) {
		return;
	}
	
	public boolean removeStudent(Student student) {
		return;
	}
	
	public boolean addWaitlist(Student student, String CourseID) {
		
		
		
		
		return;
	}
	
	public boolean removeWaitlist() {
		return;
	}
	
	public void printIndexList() {
		
	}
	
	public void printStudents() {
		
	}
}
