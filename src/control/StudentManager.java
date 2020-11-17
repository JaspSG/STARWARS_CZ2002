package control;

import entity.Course;
import entity.Student;

import java.util.ArrayList;

public class StudentManager {

	Student currentStudent = new Student();
	CourseManager cmngr = new CourseManager();

	static ArrayList<Student> listOfStudents = new ArrayList<Student>();

	public StudentManager() {
		listOfStudents = fileManager.loadStudentFile();
	}

	public StudentManager(String loginID, String password) {
		listOfStudents = fileManager.loadStudentFile();
		for (Student student : listOfStudents) {
			if (student.getLoginID().equals(loginID)) {
				this.currentStudent = student;
			}
		}

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

//	public boolean addCourse(String course, String tutGroup) {
//
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
//		// load file
////        ArrayList<String> tempListOfCurrentCourse = new ArrayList<String>();
////        tempListOfCurrentCourse = listofstudents.get(this.currentIndexOfStudent).getCourseEnrolled();
////
////        //Check if course is already registered
////        if(tempListOfCurrentCourse.contains(course.getCourseName())){
////            System.out.println("Already enrolled in course!");
////            return false;
////        }
////        //Check Schedule Clash
////        //dosomething.something();
////        //Check if there is slot,if no slots, add to waitlist instead, else:
////
////        //do Add course name to Student Object
////        tempListOfCurrentCourse.add(course.getCourseName());
////        //Add student to Course Files
////        Student tempStudent = listofstudents.get(this.currentIndexOfStudent);
////        cmgr.addStudent(tempStudent,course,tutGroup);
////
////        listofstudents.get(this.currentIndexOfStudent).setCourseEnrolled(tempListOfCurrentCourse);
////        fileManager.saveStudentFile(listofstudents);
//
//		return true; // temporary value
//	}

	public boolean dropCourse(Course course, int tutGroup) {
		return false; // temporary value
	}

	public void printCourseRegistered() {
//		int i = 1;
//		ArrayList<Course> tempCurrentCourses = new ArrayList<Course>();
//		tempCurrentCourses = listOfStudents.get(currentStudentIndex).getCourseEnrolled();
//		if (tempCurrentCourses != null) {
//			for (Course Course : tempCurrentCourses) {
//				System.out.println("Course " + i + " : " + Course.getCourseName());
//				i++;
//			}
//		} else {
//			System.out.println("No Courses registered!");
//		}
	}

	public void printVacanciesAvaliable(String courseID, String indexID) {	
		System.out.println("Vacancies: " + cmngr.checkVacancy(courseID, indexID) + " Slots" );
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
	 * @return boolean result indicating if the operation is a success or failure;
	 */
	public static boolean addNewStudent(Student student) {
		listOfStudents.add(student);
		saveStudentsFile();
		return true;
	}
	/**
	 * Updates an existing student from the current list of student
	 * @return boolean result indicating if the operation is a success or failure;
	 */
	public static boolean updateStudent(Student updateStudent) {
		for(int i = 0; i < listOfStudents.size(); i++){
			if(listOfStudents.get(i).getMatricNumber().equals(updateStudent.getMatricNumber()))
			{
				listOfStudents.set(i, updateStudent);
				break;
			}
		}
		saveStudentsFile();
		return true;
	}
	/* ------ Admin Related Methods: End ------ */
}
