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
	
	public Course findcourse(String courseID) {
		
		for(Course course: this.listOfCourses) {
			if(course.getCourseID().equals(courseID)) {
				return course;
			}
		}
		System.out.println("Course not found");
		Course emptycourse = new Course();
		return emptycourse;
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
	
	public boolean addStudentToWaitlist(Student student, String CourseID, String indexID) throws Exception {
		
		for (Course course: this.listOfCourses) {

			if(course.getCourseID().equals(CourseID)) {
				ArrayList<Index> templistindex = new ArrayList<Index>();
				templistindex = course.getIndex();
				for(Index index: templistindex) {
					if (index.getIndexID().equals(indexID)){
						index.addwaitlist(student);
						course.setIndex(templistindex);
						fileManager.saveCoursesFile(listOfCourses);
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
						Student tempstudent = index.removewaitlist();
						course.setIndex(templistindex);
						try {
							fileManager.saveCoursesFile(listOfCourses);
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

	}
	
	public void printIndexList(String CourseID) {
		
		for(Course course: this.listOfCourses) {
			
			if(course.getCourseID().equals(CourseID)) {
				ArrayList<Index> templist = course.getIndex();
				for(Index index: templist) {
					
					System.out.println(index.getIndexID());
				}
			}
		}
	}
	
	public void printStudents() {
		
	}
}
