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
			if (course.getCourseID().equals(courseID)) { // remove this check if index is unique
				ArrayList<Index> templist = course.getIndex();
				for (Index index : templist) {
					if (index.getIndexID().equals(indexID)) {
						index.addStudentToEnrolled(Student);
						System.out.println("Student Added");
						saveCoursesFile();
						return true;
					}
				}
			}
		}
		System.out.println("Course not found");
		return false;
	}

	public boolean addNewCourseToList(Course course) {

		listOfCourses.add(course);
		saveCoursesFile();
		return true;

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
							saveCoursesFile();
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
						saveCoursesFile();
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
						saveCoursesFile();
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

	public int checkVacancy(String courseID, String indexID) {

		for (Course course : listOfCourses) {
			if (course.getCourseID().equals(courseID)) {

				ArrayList<Index> templist = course.getIndex();
				for (Index index : templist) {
					if (index.getIndexID().equals(indexID)) {
						return index.checkVacancy();
					}
				}
			}
		}
		System.out.println("Course not found");
		return -1;
	}

	public void saveCoursesFile() {
		try {
			fileManager.saveCoursesFile(listOfCourses);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Course> getListOfCourses() {
		return listOfCourses;
	}

	public static void setListOfCourses(ArrayList<Course> listOfCourses) {
		CourseManager.listOfCourses = listOfCourses;
	}

	public static void printCourseList() {
		for (Course course : listOfCourses) {
			System.out.println("Course Name: " + course.getCourseName() + " Course ID: " + course.getCourseID()
					+ " Course AU: " + course.getAu());
		}
	}

}
