import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import control.CourseManager;
import control.fileManager;
import entity.Course;
import entity.Index;
import entity.Student;

public class testingfile {

	public static void main(String[] args) throws Exception {
		
		
		fileManager fmngr = new fileManager();
		
		ArrayList<Student> listofstudents = new ArrayList<Student>();
		
		Student _student1 = new Student("John Cena", "A1800123B", "Singaporean", "SCSE", 'M', 1, "loginID_1", "loginPW_1");
		
		Student _student2 = new Student("TRUMPET", "C1283713D", "Singaporean", "SCSE", 'M', 3, "loginID_2", "loginPW_2");
		
		Student _student3 = new Student("BIDEN", "E2938173F", "Malaysian", "SEEE", 'F', 2, "loginID_3", "loginPW_3");
		
		Student _student4 = new Student("BEIBER", "G2938717H", "Myanmar", "SCEE", 'F', 5, "loginID_4", "loginPW_4");
		
		Student _student5 = new Student("MICHELLE", "I29836721J", "Chinese", "SEEE", 'M', 2, "loginID_5", "loginPW_5");
		
		Student _student6 = new Student("RONALD", "K1928363L", "Chinese", "SEEE", 'F', 2, "loginID_6", "loginPW_6");
		
		Student _student7 = new Student("Ya Fei", "M12345678N", "Malaysian", "SMSE", 'M', 2, "loginID_7", "loginPW_7");
		
		Student _student8 = new Student("Wei Run", "O98765432P", "Chinese", "SCSE", 'M', 2, "loginID_8", "loginPW_8");
		
		Student _student9 = new Student("Alex Tan", "Q34123214R", "American", "SMSE", 'M', 2, "loginID_9", "loginPW_9");
		
		Student _student10 = new Student("Wonder Fei", "S29836721T", "British", "SMSE", 'M', 2, "loginID_10", "loginPW_10");
		
		
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
		
		Course _course1 = new Course("DATA STRUCTURES", "CZ1007", 3, listofindex);
	
		Course _course2 = new Course("ENGINEERING MATHEMATICS 1", "CZ1011",3, listofindex);
//		
		Course _course3 = new Course("ENGINEERING MATHEMATICS 2", "CZ1012", 3, listofindex);
//		
		Course _course4 = new Course("Digital Logic", "CZ1105", 3, listofindex);
//		
		Course _course5 = new Course("Computer Organisation & Architechture", "CZ1106", 3, listofindex);
//		
		Course _course6 = new Course("Introduction to Databases", "CZ2007", 3, listofindex);
		
		Course _course7 = new Course("PHYSICS FOUNDATION FOR ELECTRICAL & ELECTRONIC ENGINEERING", "EE1002", 4, listofindex);
		
		Course _course8 = new Course("INTRODUCTION TO BIOMOLECULAR ENGINEERING", "CB1131", 3, listofindex);
		
		Course _course9 = new Course("SUSTAINABILITY: SEEING THROUGH THE HAZE", "GC0001", 1, listofindex);
		
		Course _course10 = new Course("LATIN LANGUAGE LEVEL 2", "LX9002", 3, listofindex);
		
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
		
		
		fileManager.saveStudentFile(listofstudents); //save student file
		fileManager.saveCoursesFile(listofcourses); //save student file
		

		
// ----------------------------------------- TEST FUNCTIONS BELOW THIS LINE WITH cmngr OBJECT ----------------------------------------//
		
		CourseManager cmngr = new CourseManager();
		
		CourseManager cmngr_admin = new CourseManager();
		
		CourseManager cmngr_studentmanager = new CourseManager();
		
		Student _dummystudent = new Student("Dummy", "Dummy", "Dummy", "Dummy", 'D', 0, "Dummy", "Dummy"); //Dummy student for testing
		Student _dummystudent2 = new Student("Dummy2", "Dummy", "Dummy", "Dummy", 'D', 0, "Dummy", "Dummy");
		
		
		cmngr.addStudentToCourse(_dummystudent, "CZ1011", "SP4");
		cmngr.addStudentToCourse(_dummystudent2, "CZ1011", "SP4");
		
		Course retrivedcourse = cmngr_admin.findCourseObject("CZ1011");
		Index testindex = retrivedcourse.findIndexObject("SP4");
		testindex.printStudentsEnrolled();
		
		
//		

		
		//PRINT TESTING
		//cmngr.printIndexList("CZ1011"); 		

		//WAITLIST TESTING
		
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

		//END OF WAITLIST TESTING
		
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
