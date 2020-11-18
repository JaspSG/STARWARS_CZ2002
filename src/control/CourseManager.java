package control;

import java.util.ArrayList;

import entity.Course;
import entity.Student;

public class CourseManager {
	
	ArrayList<Course> listofstudents = new ArrayList<Course>();
	
<<<<<<< Updated upstream
	public boolean checkVacancy(String index_id) {
		return;
=======
	public CourseManager() {
		this.listOfCourses = FileManager.loadCoursesFile();
>>>>>>> Stashed changes
	}
	
	public boolean addStudent(Student student) {
		return;
	}
	
	public boolean removeStudent(Student student) {
		return;
	}
	
	public boolean addWWaitlist() {
		return;
	}
	
	public boolean removeWaitlist() {
		return;
	}
	
	public void printIndexList() {
		
<<<<<<< Updated upstream
=======
		for (Course course: this.listOfCourses) {

			if(course.getCourseID().equals(CourseID)) {
				ArrayList<Index> templistindex = new ArrayList<Index>();
				templistindex = course.getIndex();
				for(Index index: templistindex) {
					if (index.getIndexID().equals(indexID)){
						index.addwaitlist(student);
						course.setIndex(templistindex);
						FileManager.saveCoursesFile(listOfCourses);
						return true;}
					}
				}
			}
		return false;
		}
	
	public Student removeStudentFromWaitlist(String CourseID, String indexID) {
		
		for (Course course: this.listOfCourses) {

			if(course.getCourseID().equals(CourseID)) {
				ArrayList<Index> templistindex = new ArrayList<Index>();
				templistindex = course.getIndex();
				for(Index index: templistindex) {
					if (index.getIndexID().equals(indexID)){
						Student tempstudent = index.removeStudentFromWaitlist();
						course.setIndex(templistindex);
						try {
							FileManager.saveCoursesFile(listOfCourses);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return tempstudent;}
					}
				}
			}
		Student emptystudent = new Student();
		return emptystudent;

>>>>>>> Stashed changes
	}
	
	public void printStudents() {
		
	}
}
