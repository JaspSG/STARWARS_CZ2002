import control.CourseManager;
import control.StudentManager;
import control.fileManager;
import entity.*;

import java.util.ArrayList;
import java.util.Arrays;

public class testingfile {

	public static void main(String[] args) throws Exception {

		fileManager fmngr = new fileManager();
		CourseManager cmngr = new CourseManager();
		

		String password = "password";
		password = User.hashString(password);
		
		ArrayList<Student> listofstudents = new ArrayList<Student>();
		ArrayList<Index> listofindex = new ArrayList<Index>();
		ArrayList<Course> listofcourses = new ArrayList<Course>();

		/* ------------------------- Start of Student ------------------------- */
		
		Student _student1 = new Student("Student", "A0000000B", "Singaporean", "SCSE", 'M', 1, "student",
				password, "wong1173@e.ntu.edu.sg");
		
		listofstudents.add(_student1);
		
		/* ------------------------- End of Student ------------------------- */
		
		/* ------------------------- Start of Admin ------------------------- */
		ArrayList<Admin> listofAdmin = new ArrayList<Admin>();

//		String password = "password";
//		password = User.hashString(password);

		Admin _admin1 = new Admin("admin1", password);

		Admin _admin2 = new Admin("admin2", password);

		listofAdmin.add(_admin1);

		listofAdmin.add(_admin2);

		/* ------------------------- End of Admin ------------------------- */
		
		/* ------------------------- Start of Course creation ------------------------- */
		
		Course cz2001 = new Course("CZ2001", "Algorithms", "SCSE", 3);
		Index _index1 = new Index("200101");
		Lesson _lesson1 =  new Lesson("Lab", 0, 3 , 2);
		Lesson _lesson2 = new Lesson("Lecture", 0, 5, 1);
		Lesson _lesson3 = new Lesson("Tutorial", 2,5,1);
		Lesson _lesson4 = new Lesson("Lecture", 4,3,1);
		
		_index1.addToLessons(_lesson1);
		_index1.addToLessons(_lesson2);
		_index1.addToLessons(_lesson3);
		_index1.addToLessons(_lesson4);
		
		cz2001.addToIndex(_index1);
		
		
		Course cz2002 = new Course("CZ2002", "Object-Oriented Design", "SCSE", 3);
		Index _index2 = new Index("200201");
		Lesson _lesson5 = new Lesson("Lecture", 1,2,1);
		Lesson _lesson6 = new Lesson("Lab", 2,3,2);
		Lesson _lesson7 = new Lesson("Tutorial", 2,8,1);
		Lesson _lesson8 = new Lesson("Lecture", 4,4,1);
		
		_index2.addToLessons(_lesson5);
		_index2.addToLessons(_lesson6);
		_index2.addToLessons(_lesson7);
		_index2.addToLessons(_lesson8);
		
		cz2002.addToIndex(_index2);
		
		Course cz2003 = new Course("CZ2003", "Computer Visualisation", "SCSE", 3);
		Index _index3 = new Index("200301");
		Lesson _lesson9 = new Lesson("Lab", 0,7,2);
		Lesson _lesson10 = new Lesson("Tutorial", 1,4,1);
		Lesson _lesson11 = new Lesson("Lecture", 1,8,1);
		Lesson _lesson12 = new Lesson("Lecture", 4,7,1);
		
		_index3.addToLessons(_lesson9);
		_index3.addToLessons(_lesson10);
		_index3.addToLessons(_lesson11);
		_index3.addToLessons(_lesson12);
		
		cz2003.addToIndex(_index3);
		
		
		Course cz2005 = new Course("CZ2005", "Operating Systems", "SCSE", 3);
		Index _index4 = new Index("200501");
		Lesson _lesson13 = new Lesson("Lab", 1, 5,2);
		Lesson _lesson14 = new Lesson("Lecture", 1, 5,2);
		Lesson _lesson15 = new Lesson("Tutorial", 4,6,1);
		
		_index4.addToLessons(_lesson13);
		_index4.addToLessons(_lesson14);
		_index4.addToLessons(_lesson15);
		
		cz2005.addToIndex(_index4);
		
		Course cz2006 = new Course("CZ2006", "Software Engineering", "SCSE", 3 );
		Index _index5 = new Index("200501");
		Lesson _lesson16 = new Lesson("Lecture", 0,2,1);
		Lesson _lesson17 = new Lesson("Lab", 2,1,2);
		Lesson _lesson18 = new Lesson("Tutorial", 3,1,1);
		Lesson _lesson19 = new Lesson("Lecture", 3,6,1);
		
		_index5.addToLessons(_lesson16);
		_index5.addToLessons(_lesson17);
		_index5.addToLessons(_lesson18);
		_index5.addToLessons(_lesson19);
		
		cz2006.addToIndex(_index5);
		
		Course cz2007 = new Course("CZ2007", "Database", "SCSE", 3);
		Index _index6 = new Index("200701");
		Lesson _lesson20 = new Lesson("Lecture", 0,6,1);
		Lesson _lesson21 = new Lesson("Tutorial", 1,1,1);
		Lesson _lesson22 = new Lesson("Lecture", 3,5,1);
		
		_index6.addToLessons(_lesson20);
		_index6.addToLessons(_lesson21);
		_index6.addToLessons(_lesson22);
		
		cz2007.addToIndex(_index6);
		
		listofcourses.add(cz2001);
		listofcourses.add(cz2002);
		listofcourses.add(cz2003);
		listofcourses.add(cz2005);
		listofcourses.add(cz2006);
		listofcourses.add(cz2007);
		
		/* ------------------------- end of Course creation ------------------------- */
		
//		System.out.println(_student1.getLoginPW());

//		Student _student2 = new Student("TRUMPET", "C1283713D", "Singaporean", "SCSE", 'M', 3, "loginID_2", password,
//				"wong1173@e.ntu.edu.sg");
//
//		Student _student3 = new Student("BIDEN", "E2938173F", "Malaysian", "SEEE", 'F', 2, "loginID_3", password,
//				"wong1173@e.ntu.edu.sg");
//
//		Student _student4 = new Student("BEIBER", "G2938717H", "Myanmar", "SCEE", 'F', 5, "loginID_4", "loginPW_4",
//				"wong1173@e.ntu.edu.sg");
//
//		Student _student5 = new Student("MICHELLE", "I29836721J", "Chinese", "SEEE", 'M', 2, "loginID_5", "loginPW_5",
//				"wong1173@e.ntu.edu.sg");
//
//		Student _student6 = new Student("RONALD", "K1928363L", "Chinese", "SEEE", 'F', 2, "loginID_6", "loginPW_6",
//				"wong1173@e.ntu.edu.sg");
//
//		Student _student7 = new Student("Ya Fei", "M12345678N", "Malaysian", "SMSE", 'M', 2, "loginID_7", "loginPW_7",
//				"wong1173@e.ntu.edu.sg");
//
//		Student _student8 = new Student("Wei Run", "O98765432P", "Chinese", "SCSE", 'M', 2, "loginID_8", "loginPW_8",
//				"wong1173@e.ntu.edu.sg");
//
//		Student _student9 = new Student("Alex Tan", "Q34123214R", "American", "SMSE", 'M', 2, "loginID_9", "loginPW_9",
//				"wong1173@e.ntu.edu.sg");
//
//		Student _student10 = new Student("Wonder Fei", "S29836721T", "British", "SMSE", 'M', 2, "loginID_10",
//				"loginPW_10", "wong1173@e.ntu.edu.sg");
//
//		listofstudents.add(_student1);
//		listofstudents.add(_student2);
//		listofstudents.add(_student3);
//		listofstudents.add(_student4);
//		listofstudents.add(_student5);
//		listofstudents.add(_student6);
//		listofstudents.add(_student7);
//		listofstudents.add(_student8);
//		listofstudents.add(_student9);
//		listofstudents.add(_student10);

		fileManager.saveStudentFile(listofstudents); // save student file
		fileManager.saveCoursesFile(listofcourses); // save student file
		fileManager.saveAdminFile(listofAdmin); // save admin file
		
		cmngr.printCourseList();
		

// ----------------------------------------- TEST FUNCTIONS BELOW THIS LINE WITH cmngr OBJECT ----------------------------------------//


		
		
//		Lesson templesson = new Lesson("LAB", 3, 2, 1); //start / end / day
//		
//		String[][] array = new String[10][7];
//		
//		for(int i=0; i<10; i++) {
//			
//			for(int j=0; j<7; j++) {
//				array[i][j] = " ";
//				//System.out.println(array[i][j]);
//			}
//		}
//		
//		
//		for(int j=templesson.getStartTime(); j<(templesson.getStartTime()+templesson.getDuration());j++ ) {
//			array[j][0] = "lesson";
//		}
//		
//		print2D(array);
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// LESSON CREATION //
		//day , start time, duration
		//Lesson _lesson1 =  new Lesson("Lecture", 0, 2 , 1);

		
		
 
		
//		x.printVacanciesAvaliable("CZ1011", "SP4");

//		System.out.println(retrivedcourse.getCourseID());

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
	public static void print2D(String[][] array) 
	{ 
	    // Loop through all rows 
	    for (String[] row : array) 

	        // converting each row as string 
	        // and then printing in a separate line 
	        System.out.println(Arrays.toString(row)); 
	}
}

