import control.CourseManager;
import control.StudentManager;
import control.fileManager;
import entity.*;

import java.util.ArrayList;

public class testingfile {

	public static void main(String[] args) throws Exception {

		fileManager fmngr = new fileManager();

		String password = "password";
		password = User.hashString(password);
		
		ArrayList<Student> listofstudents = new ArrayList<Student>();

		Student _student1 = new Student("John Cena", "A1800123B", "Singaporean", "SCSE", 'M', 1, "student",
				password, "wong1173@e.ntu.edu.sg");
		
		System.out.println(_student1.getLoginPW());

		Student _student2 = new Student("TRUMPET", "C1283713D", "Singaporean", "SCSE", 'M', 3, "loginID_2", password,
				"wong1173@e.ntu.edu.sg");

		Student _student3 = new Student("BIDEN", "E2938173F", "Malaysian", "SEEE", 'F', 2, "loginID_3", password,
				"wong1173@e.ntu.edu.sg");

		Student _student4 = new Student("BEIBER", "G2938717H", "Myanmar", "SCEE", 'F', 5, "loginID_4", "loginPW_4",
				"wong1173@e.ntu.edu.sg");

		Student _student5 = new Student("MICHELLE", "I29836721J", "Chinese", "SEEE", 'M', 2, "loginID_5", "loginPW_5",
				"wong1173@e.ntu.edu.sg");

		Student _student6 = new Student("RONALD", "K1928363L", "Chinese", "SEEE", 'F', 2, "loginID_6", "loginPW_6",
				"wong1173@e.ntu.edu.sg");

		Student _student7 = new Student("Ya Fei", "M12345678N", "Malaysian", "SMSE", 'M', 2, "loginID_7", "loginPW_7",
				"wong1173@e.ntu.edu.sg");

		Student _student8 = new Student("Wei Run", "O98765432P", "Chinese", "SCSE", 'M', 2, "loginID_8", "loginPW_8",
				"wong1173@e.ntu.edu.sg");

		Student _student9 = new Student("Alex Tan", "Q34123214R", "American", "SMSE", 'M', 2, "loginID_9", "loginPW_9",
				"wong1173@e.ntu.edu.sg");

		Student _student10 = new Student("Wonder Fei", "S29836721T", "British", "SMSE", 'M', 2, "loginID_10",
				"loginPW_10", "wong1173@e.ntu.edu.sg");

		listofstudents.add(_student1);
		listofstudents.add(_student2);
		listofstudents.add(_student3);
		listofstudents.add(_student4);
		listofstudents.add(_student5);
		listofstudents.add(_student6);
		listofstudents.add(_student7);
		listofstudents.add(_student8);
		listofstudents.add(_student9);
		listofstudents.add(_student10);

		ArrayList<Index> listofindex = new ArrayList<Index>();

		Index _index1 = new Index("SS2");
		_index1.setTotalSize(20);

		Index _index2 = new Index("SP4");

		Index _index3 = new Index("SP5");

		Index _index4 = new Index("SS6");

		Index _index5 = new Index("SS7");

		Index _index6 = new Index("SS8");

		Index _index7 = new Index("FP5");

		Index _index8 = new Index("FP6");

		Index _index9 = new Index("FP7");

		Index _index10 = new Index("SS3");

		listofindex.add(_index1);
		listofindex.add(_index2);
		listofindex.add(_index3);
		listofindex.add(_index4);
		listofindex.add(_index5);

		ArrayList<Course> listofcourses = new ArrayList<Course>();

		Course _course1 = new Course("CZ1007", "DATA STRUCTURES", "SCSE", 3, listofindex);

		Course _course2 = new Course("CZ1011", "ENGINEERING MATHEMATICS 1", "SCSE", 3, listofindex);
//
		Course _course3 = new Course("CZ1012", "ENGINEERING MATHEMATICS 2", "SCSE", 3, listofindex);
//
		Course _course4 = new Course("CZ1105", "Digital Logic", "SCSE", 3, listofindex);
//
		Course _course5 = new Course("CZ1106", "Computer Organisation & Architechture", "SCSE", 3, listofindex);
//
		Course _course6 = new Course("CZ2007", "Introduction to Databases", "SCSE", 3, listofindex);

		Course _course7 = new Course("EE1002", "PHYSICS FOUNDATION FOR ELECTRICAL & ELECTRONIC ENGINEERING", "EEE", 4,
				listofindex);

		Course _course8 = new Course("CB1131", "INTRODUCTION TO BIOMOLECULAR ENGINEERING", "SCBE", 3, listofindex);

		Course _course9 = new Course("GC0001", "SUSTAINABILITY: SEEING THROUGH THE HAZE", "HASS", 1, listofindex);

		Course _course10 = new Course("LX9002", "LATIN LANGUAGE LEVEL 2", "HASS", 3, listofindex);

		listofcourses.add(_course10);
		listofcourses.add(_course9);
		listofcourses.add(_course8);
		listofcourses.add(_course7);
		listofcourses.add(_course6);
		listofcourses.add(_course5);
		listofcourses.add(_course4);
		listofcourses.add(_course3);
		listofcourses.add(_course2);
		listofcourses.add(_course1);

		/* ------------------------- Start ofAdmin ------------------------- */
		ArrayList<Admin> listofAdmin = new ArrayList<Admin>();

//		String password = "password";
//		password = User.hashString(password);

		Admin _admin1 = new Admin("admin1", password);

		Admin _admin2 = new Admin("admin2", password);

		listofAdmin.add(_admin1);

		listofAdmin.add(_admin2);

		/* ------------------------- End of Admin ------------------------- */

		fileManager.saveStudentFile(listofstudents); // save student file
		fileManager.saveCoursesFile(listofcourses); // save student file
		fileManager.saveAdminFile(listofAdmin); // save admin file

// ----------------------------------------- TEST FUNCTIONS BELOW THIS LINE WITH cmngr OBJECT ----------------------------------------//

		CourseManager cmngr = new CourseManager();

		CourseManager cmngr_admin = new CourseManager();

		CourseManager cmngr_studentmanager = new CourseManager();

//		Student _dummystudent = new Student("Dummy", "Dummy", "Dummy", "Dummy", 'D', 0, "Dummy", "Dummy"); //Dummy student for testing
//		Student _dummystudent2 = new Student("Dummy2", "Dummy", "Dummy", "Dummy", 'D', 0, "Dummy", "Dummy");
//
//
//		cmngr.addStudentToCourse(_dummystudent, "CZ1011", "SP4");
//		cmngr.addStudentToCourse(_dummystudent2, "CZ1011", "SP4");

		Course retrivedcourse = CourseManager.findCourseObject("CZ1011");
		Index testindex = retrivedcourse.findIndexObject("SP4");
		testindex.printStudentsEnrolled();

		StudentManager x = new StudentManager();

		x.printVacanciesAvaliable("CZ1011", "SP4");

		System.out.println(retrivedcourse.getCourseID());

//

		// PRINT TESTING
		// cmngr.printIndexList("CZ1011");

		// WAITLIST TESTING

//		cmngr.addStudentToWaitlist(_student2, "CZ1011", "SP4"); //ADDING
//		cmngr.addStudentToWaitlist(_student1, "CZ1011", "SP4");
//
//		Course retrivedcourse = cmngr.findCourseObject("CZ1011");
//		Index testindex = retrivedcourse.findIndexObject("SP4");
//
//		System.out.println("Students Currently in queue:");
//		testindex.printQueue();
//
//
//		Student studentremoved = cmngr.removeStudentFromWaitlist("CZ1011", "SP4"); //REMOVING
//		System.out.println("STUDENT REMOVED FROM COURSE/INDEX QUEUE: " + studentremoved.getName());
//		System.out.println("Students left in queue:");
//		testindex.printQueue();
//
//		//Testing how to check if the course object is an empty object with null
//		Course newcourse = new Course();
//		if (newcourse.getCourseID() == null) {
//			System.out.println("Course is empty!");
//		};

		// END OF WAITLIST TESTING

//

//		ADD_STUDENTS TESTING
//		cmngr.addStudent(_dummystudent, "CZ1011", "SP4");
//		Course tempcourse = CourseManager.findCourseObject("CZ1011");
//		System.out.println(tempcourse.getCourseID());
//		Index tempindex = tempcourse.findIndexObject("SP4");
//		tempindex.printStudentsEnrolled();
//
////		tempindex.printStudentsEnrolled();
//
//		tempindex.removeStudentFromEnrolled(_dummystudent);
//		tempindex.printStudentsEnrolled();

//		END OF ADDING STUDENTS TESTING

	}

}
