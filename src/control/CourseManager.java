package control;

import java.util.ArrayList;

import entity.Course;
import entity.Index;
import entity.Student;

public class CourseManager {
	
	ArrayList<Course> listOfCourses = new ArrayList<Course>();
	
	public CourseManager() {
		this.listOfCourses = fileManager.loadCoursesFile();
	}
	
	public boolean checkVacancy(String index_id) {//
		return;
	}
	
	public boolean addStudent(Student tempStudent,Course course, String tutGroup) {
		return;
	}
	
	public boolean removeStudent(Student student) {
		return;
	}
	
	public boolean addWaitlist(Student student, String CourseID, String indexID) throws Exception {
		
		for (Course course: this.listOfCourses) {
			if(course.getCourseID() == CourseID) {
				ArrayList<Index> tempindex = new ArrayList<Index>();
				tempindex = course.getIndex();
				for(Index index: tempindex) {
					if (index.getIndexID() == indexID) {
						index.addwaitlist(student);
						break;
					}
				}
				course.setIndex(tempindex);
				fileManager.saveCoursesFile(listOfCourses);
				return true;
			}
		}
		return false;
	}
	
	public boolean removeWaitlist(String CourseID, String indexID) {
		
		for(Course course: this.listOfCourses) {
			if(course.getCourseID() == CourseID) {
				ArrayList<Index> tempindex = new ArrayList<Index>();
				tempindex = course.getIndex();
				for(Index index: tempindex) {
					if(index.getIndexID() == indexID) {
						index.removewaitlist();
					}
					break;
				}
				course.setIndex(tempindex);
				try {
					fileManager.saveCoursesFile(listOfCourses);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}
	
	public void printIndexList() {
		
	}
	
	public void printStudents() {
		
	}
}
