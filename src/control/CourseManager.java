package control;

import java.util.ArrayList;

import entity.Course;
import entity.Index;
import entity.Student;

public class CourseManager {

	static ArrayList<Course> listOfCourses = new ArrayList<Course>();

	public CourseManager() {
		listOfCourses = fileManager.loadCoursesFile();
	}

	public static Course findCourseObject(String courseID) {

		for (Course course : listOfCourses) {
			if (course.getCourseID().equals(courseID)) {
				return course;
			}
		}
		System.out.println("Course not found");
		Course emptycourse = new Course();
		return emptycourse; // NOTE: STRING DEFAULTS ARE NULL, HENCE TO CHECK IF OBJECT IS EMPTY, CHECK IF A
							// STRING ATTRIBUTE IS NULL
	}

	public boolean addStudentToCourse(Student Student, String courseID, String indexID) {

		for (Course course : listOfCourses) {
			if (course.getCourseID().equals(courseID)) {
				ArrayList<Index> templist = course.getIndex();
				for (Index index : templist) {
					if (index.getIndexID().equals(indexID)) {
						index.addStudentToEnrolled(Student);
						System.out.println("Student Added");
						try {
							fileManager.saveCoursesFile(listOfCourses);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return true;
					}
				}
			}
		}
		System.out.println("Course not found");
		return false;
	}

	public boolean removeStudentFromCourse(Student student, String courseID) {

		for (Course course : listOfCourses) {
			if (course.getCourseID().equals(courseID)) {
				ArrayList<Index> tempindexlist = course.getIndex();

				for (Index index : tempindexlist) {

					ArrayList<Student> tempstudentlist = index.getStudentsEnrolled();

					for (Student targetstudent : tempstudentlist) {
						if (targetstudent.getMatricNumber().equals(student.getMatricNumber())) {
							index.removeStudentFromEnrolled(student);
							System.out.println("Student: " + student.getName() + "removed from course " + courseID);
							return true;
						}
					}

				}
			}

		}
		System.out.println("Something went wrong - removeStudent function");
		return false;
	}

	public boolean addStudentToWaitlist(Student student, String CourseID, String indexID) throws Exception {

		for (Course course : listOfCourses) {

			if (course.getCourseID().equals(CourseID)) {
				ArrayList<Index> templistindex = new ArrayList<Index>();
				templistindex = course.getIndex();
				for (Index index : templistindex) {
					if (index.getIndexID().equals(indexID)) {
						index.addStudentToWaitlist(student);
						course.setIndex(templistindex);
						fileManager.saveCoursesFile(listOfCourses);
						return true;
					}
				}
			}
		}
		return false;
	}

	public Student removeStudentFromWaitlist(String CourseID, String indexID) {

		for (Course course : listOfCourses) {

			if (course.getCourseID().equals(CourseID)) {
				ArrayList<Index> templistindex = new ArrayList<Index>();
				templistindex = course.getIndex();
				for (Index index : templistindex) {
					if (index.getIndexID().equals(indexID)) {
						Student tempstudent = index.removeStudentFromWaitlist();
						course.setIndex(templistindex);
						try {
							fileManager.saveCoursesFile(listOfCourses);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return tempstudent;
					}
				}
			}
		}
		Student emptystudent = new Student();
		return emptystudent;

	}

	public void printIndexList(String CourseID) {

		for (Course course : listOfCourses) {

			if (course.getCourseID().equals(CourseID)) {
				ArrayList<Index> templist = course.getIndex();
				for (Index index : templist) {

					System.out.println(index.getIndexID());
				}
			}
		}
	}

	public boolean checkVacancy(String courseID, String indexID) {
		return false;
	}

	public static ArrayList<Course> getListOfCourses() {
		return listOfCourses;
	}

	public static void setListOfCourses(ArrayList<Course> listOfCourses) {
		CourseManager.listOfCourses = listOfCourses;
	}

}
