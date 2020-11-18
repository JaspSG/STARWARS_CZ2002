package control;

import entity.Course;
import entity.Student;

import java.util.ArrayList;

public class StudentManager {

	Student currentStudent = new Student();
	CourseManager cmngr = new CourseManager();
	int studentIndex;
	static ArrayList<Student> listOfStudents = new ArrayList<Student>();

	public StudentManager() {
		listOfStudents = fileManager.loadStudentFile();

	}

	public StudentManager(String loginID) {
		listOfStudents = fileManager.loadStudentFile();
		studentIndex = 0;
		for (Student student : listOfStudents) {
			if (student.getLoginID().equals(loginID)) {
				this.currentStudent = student;
				studentIndex = listOfStudents.indexOf(currentStudent);
			}
		}
		//System.out.println("The index is : "+studentIndex);

	}

	public StudentManager(int index) {
		listOfStudents = fileManager.loadStudentFile();
		studentIndex = index;
		currentStudent = listOfStudents.get(studentIndex);

	}

	public static Student findStudentObject(String matriculationNumber) {
		for (Student student : listOfStudents) {
			if (student.getMatricNumber().equals(matriculationNumber)) {
				return student;
			}
		}
		System.out.println("Student not found");
		Student emptyStudent = new Student();
		return emptyStudent; // NOTE: STRING DEFAULTS ARE NULL, HENCE TO CHECK IF OBJECT IS EMPTY, CHECK IF A
		// STRING ATTRIBUTE IS NULL
	}

	public static void saveStudentsFile() {
		try {
			fileManager.saveStudentFile(listOfStudents);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Student> getListOfStudents() {
		return listOfStudents;
	}

	public static void setListOfStudents(ArrayList<Student> listOfStudents) {
		StudentManager.listOfStudents = listOfStudents;
	}

//	int currentStudentIndex;
//
//	public StudentManager(int global_i) {
//		currentStudentIndex = global_i;
//		listOfStudents = fileManager.loadStudentFile();
//	} // to remove

	public boolean addCourse(String course, String indexID) {

		System.out.println("Adding Course ID : " + course + " and Index ID : " + indexID);
		// Searching if course exists

		if (CourseManager.findCourseObject(course).getCourseID() != null) {
			System.out.println("Course Exists");
			// Add in a check for wait list
			ArrayList<Course> enrolledCourses = currentStudent.getCourseEnrolled();
			if (enrolledCourses != null) {
				for (Course enrolledCourse : enrolledCourses) {
					if (enrolledCourse.getCourseID().equals(course)) {
						System.out.println("Already enrolled in this course!");
						return false;
					}

				}
				System.out.println("Adding student to course!");
				cmngr.addStudentToCourse(currentStudent, course, indexID);
				enrolledCourses.add(CourseManager.findCourseObject(course));
				listOfStudents.get(studentIndex).setCourseEnrolled(enrolledCourses);
				saveStudentsFile();
				System.out.println("Successful!");
				return true;
			}
			// If no enrolled courses :
			else {
				// Add student to Course Object
				System.out.println("Adding student to course!");
				cmngr.addStudentToCourse(currentStudent, course, indexID);
				// Add Course to Student Object
				enrolledCourses = new ArrayList<Course>();
				enrolledCourses.add(CourseManager.findCourseObject(course));
				listOfStudents.get(studentIndex).setCourseEnrolled(enrolledCourses);
				// Save students
				saveStudentsFile();
				System.out.println("Successful!");
				return true;

			}

		}
		System.out.println("Course does not exist!");
		return false; // temporary value
	}
//		ArrayList<Course> listOfCourses = new ArrayList<Course>();
//		listOfCourses = fileManager.loadCoursesFile();
//		System.out.println("AddingCourse : " + course + "Group: " + tutGroup);
//		ArrayList<Course> tempCurrentCourses = new ArrayList<Course>();
//		tempCurrentCourses = listOfStudents.get(currentStudentIndex).getCourseEnrolled();
//		for (Course Courses : listOfCourses) {
//			// System.out.println(Courses.getCourseID());
//			if (Courses.getCourseID().equals(course)) {
//				// System.out.println("Course exists!");
//				if (tempCurrentCourses != null) {
//					for (Course CheckCurrentCourse : tempCurrentCourses) {
//						if (CheckCurrentCourse.getCourseID().equals(course)) {
//							System.out.println("Already enrolled in course!");
//							return false;
//						} else {
//							cmngr.addStudent(listOfStudents.get(currentStudentIndex), course, tutGroup);
//							tempCurrentCourses.add(Courses);
//							listOfStudents.get(currentStudentIndex).setCourseEnrolled(tempCurrentCourses);
//							System.out.println("Adding Student to Course!");
//							try {
//								fileManager.saveStudentFile(listOfStudents);
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//							return true;
//						}
//					}
//				} else {
//					cmngr.addStudent(listOfStudents.get(currentStudentIndex), course, tutGroup);
//					tempCurrentCourses = new ArrayList<Course>();
//					tempCurrentCourses.add(Courses);
//					listOfStudents.get(currentStudentIndex).setCourseEnrolled(tempCurrentCourses);
//					System.out.println("Added!");
//					try {
//						fileManager.saveStudentFile(listOfStudents);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					return true;
//				}
//			}
//		}
//		System.out.println("Course does not exist!");

	public boolean dropCourse(String course) {

		ArrayList<Course> coursesEnrolled = currentStudent.getCourseEnrolled();
		if (coursesEnrolled != null) {
			Course courseobject = CourseManager.findCourseObject(course);
			if (courseobject != null) {
				System.out.println("Course ID of dropped course is : " + courseobject.getCourseID());
				for (Course courses : coursesEnrolled) {
					if (courses.getCourseID() == courseobject.getCourseID()) {
						// Drop the class and remove student
						System.out.println("Dropping Course!");
						cmngr.removeStudentFromCourse(currentStudent, course);
						coursesEnrolled.remove(courseobject);
						listOfStudents.get(studentIndex).setCourseEnrolled(coursesEnrolled);
						saveStudentsFile();
						return true;
					}
				}
				System.out.println("You do not have this course!");
				return false;

			} else {
				System.out.println("Invalid course!");
				return false;
			}
		}
		System.out.println("No courses available to drop!");
		return false; // temporary value
	}

	public void printCourseRegistered() {
		
		if (currentStudent.getCourseEnrolled() != null) {
			System.out.println("----------------------------------------------------");
			System.out.println("|  Course ID |  Course Name                        |");
			System.out.println("----------------------------------------------------");
			for (Course Course : currentStudent.getCourseEnrolled()) {
				System.out.format("| %-11s| %-36s|\n", Course.getCourseID(), Course.getCourseName());
			}
		} else {
			System.out.println("No Courses registered!");
		}
	}

	public void printVacanciesAvaliable(String courseID, String indexID) {
		System.out.println("Vacancies: " + cmngr.checkVacancy(courseID, indexID) + " Slots");
	}

	public boolean changeIndex(Course course, String indexID) {
		return true; // temporary value
	}

	public boolean swapIndex(Course course, String indexID, Student student) {
		return true; // temp value
	}

//	public void removeFromWaitlist() {
//
//	}
//
//	public void addToWaitlist() {
//
//	}

	/* ------ Admin Related Methods: Start ------ */
	/**
	 * Adds a new student to the current list of students
	 * 
	 * @return boolean result indicating if the operation is a success or failure;
	 */
	public static boolean addNewStudent(Student student) {
		listOfStudents.add(student);
		saveStudentsFile();
		return true;
	}

	/**
	 * Updates an existing student from the current list of student
	 * 
	 * @return boolean result indicating if the operation is a success or failure;
	 */
	public static boolean updateStudent(Student updateStudent) {
		for (int i = 0; i < listOfStudents.size(); i++) {
			if (listOfStudents.get(i).getMatricNumber().equals(updateStudent.getMatricNumber())) {
				listOfStudents.set(i, updateStudent);
				break;
			}
		}
		saveStudentsFile();
		return true;
	}
	/* ------ Admin Related Methods: End ------ */
}
