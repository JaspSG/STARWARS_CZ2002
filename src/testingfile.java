import control.CourseManager;
import control.StudentManager;
import control.fileManager;
import entity.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class testingfile {

	public static void main(String[] args) throws Exception {
		

		String password = "password";
		password = User.hashString(password);
		
		ArrayList<Student> listofstudents = new ArrayList<Student>();
		ArrayList<Index> listofindex = new ArrayList<Index>();
		ArrayList<Course> listofcourses = new ArrayList<Course>();

		/* ------------------------- Start of Student ------------------------- */
		
		Student _student1 = new Student("Student", "001", "Singaporean", "SCSE", 'M', 1, "student",
				password, "cz2002gatsby@gmail.com");
		Student _student2 = new Student("Student2", "002", "Singaporean", "SCSE", 'F', 1, "student2",
				password, "cz2002gatsby@gmail.com");
		Student _student3 = new Student("James Graham", "A0000780B", "Singaporean", "SCSE", 'M', 2, "student3",
				password, "cz2002gatsby@gmail.com");
		Student _student4 = new Student("Willy Wonka", "C1700222D", "Singaporean", "SCSE", 'M', 3, "student4",
				password, "cz2002gatsby@gmail.com");
		Student _student5 = new Student("Cena Mareatte", "U1922333B", "Malaysian", "SCSE", 'F', 2, "student5",
				password, "cz2002gatsby@gmail.com");
		Student _student6 = new Student("Trumpity Wumpity", "U1622999D", "American", "SCSE", 'M', 1, "student6",
				password, "cz2002gatsby@gmail.com");

		//Permanent access time for _student1
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Calendar startCalendar = Calendar.getInstance();
		Calendar endCalendar = Calendar.getInstance();
		String startTime = "2020/11/20";
		String endTime = "2021/11/20";
		startCalendar.setTime(simpleDateFormat.parse(startTime));
		endCalendar.setTime(simpleDateFormat.parse(endTime));
		
		_student1.setStartTime(startCalendar);
		_student1.setEndTime(endCalendar);
//		
//		
//		System.out.println(_student1.getEndTime().toString());
//		
//		_student1.setStartTime(startCalendar);
//		_student1.setEndTime(startCalendar);
		
		listofstudents.add(_student1);
		listofstudents.add(_student2);
		listofstudents.add(_student3);
		listofstudents.add(_student4);
		listofstudents.add(_student5);
		listofstudents.add(_student6);
		
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
		
		/*--------------------------------cz2001-----------------------*/
		
		Course cz2001 = new Course("CZ2001", "Algorithms", "SCSE", 3);
		Index _index1_1 = new Index("10124");
		Lesson _lesson1_1_1 = new Lesson("Lecture", 4,1,1);
		Lesson _lesson1_1_4 = new Lesson("Lecture", 0,3,1);
		Lesson _lesson1_1_3 = new Lesson("Tutorial", 3,9,1);
		Lesson _lesson1_1_2 = new Lesson("Lab", 2,3,2);

		_index1_1.addToLessons(_lesson1_1_1);
		_index1_1.addToLessons(_lesson1_1_2);
		_index1_1.addToLessons(_lesson1_1_3);
		_index1_1.addToLessons(_lesson1_1_4);
		
		cz2001.addToIndex(_index1_1);

		
		Index _index1_2 = new Index("10125");
		Lesson _lesson1_2_1 = new Lesson("Lecture", 4,1,1);
		Lesson _lesson1_2_4 = new Lesson("Lecture", 0,3,1);
		Lesson _lesson1_2_3 = new Lesson("Tutorial", 2,6,1);
		Lesson _lesson1_2_2 = new Lesson("Lab", 2,1,2);
		
		_index1_2.addToLessons(_lesson1_2_1);
		_index1_2.addToLessons(_lesson1_2_2);
		_index1_2.addToLessons(_lesson1_2_3);
		_index1_2.addToLessons(_lesson1_2_4);
		
		cz2001.addToIndex(_index1_2);
		
		/*--------------------------------cz2001-----------------------*/
		
		/*--------------------------------cz2002-----------------------*/
		
		Course cz2002 = new Course("CZ2002", "Object-Oriented Design", "SCSE", 3);
		Index _index2_1 = new Index("10126");
		Lesson _lesson2_1_1 = new Lesson("Lecture", 3,1,1);
		Lesson _lesson2_1_4 = new Lesson("Lecture", 1,7,1);
		Lesson _lesson2_1_3 = new Lesson("Tutorial", 2,2,1);
		Lesson _lesson2_1_2 = new Lesson("Lab", 0,7,2);
		
		_index2_1.addToLessons(_lesson2_1_1);
		_index2_1.addToLessons(_lesson2_1_2);
		_index2_1.addToLessons(_lesson2_1_3);
		_index2_1.addToLessons(_lesson2_1_4);

		cz2002.addToIndex(_index2_1);

		Index _index2_2 = new Index("10127");
		Lesson _lesson2_2_1 = new Lesson("Lecture", 3,1,1);
		Lesson _lesson2_2_4 = new Lesson("Lecture", 1,7,1);
		Lesson _lesson2_2_2 = new Lesson("Lab", 0,7,2);
		Lesson _lesson2_2_3 = new Lesson("Tutorial", 2,2,1);
		
		_index2_2.addToLessons(_lesson2_2_1);
		_index2_2.addToLessons(_lesson2_2_2);
		_index2_2.addToLessons(_lesson2_2_3);
		_index2_2.addToLessons(_lesson2_2_4);
		
		cz2002.addToIndex(_index2_2);
		
		/*--------------------------------cz2002-----------------------*/
		
		/*--------------------------------cz2003-----------------------*/
		Course cz2003 = new Course("CZ2003", "Computer Visualisation", "SCSE", 3);
		Index _index3_1 = new Index("10128");
		Lesson _lesson3_1_1 = new Lesson("Lecture", 3,4,1);
		Lesson _lesson3_1_2 = new Lesson("Lecture", 0,9,1);
		Lesson _lesson3_1_3 = new Lesson("Tutorial", 4,8,1);
		Lesson _lesson3_1_4 = new Lesson("Lab", 2,5,2);
		
		_index3_1.addToLessons(_lesson3_1_1);
		_index3_1.addToLessons(_lesson3_1_2);
		_index3_1.addToLessons(_lesson3_1_3);
		_index3_1.addToLessons(_lesson3_1_4);
		
		cz2003.addToIndex(_index3_1);
		
		Index _index3_2 = new Index("10129");
		Lesson _lesson3_2_1 = new Lesson("Lecture", 3,4,1);
		Lesson _lesson3_2_2 = new Lesson("Lecture", 0,9,1);
		Lesson _lesson3_2_3 = new Lesson("Tutorial", 2,6,1);
		Lesson _lesson3_2_4 = new Lesson("Lab", 4,5,2);
		
		_index3_2.addToLessons(_lesson3_2_1);
		_index3_2.addToLessons(_lesson3_2_2);
		_index3_2.addToLessons(_lesson3_2_3);
		_index3_2.addToLessons(_lesson3_2_4);
		
		cz2003.addToIndex(_index3_2);
		
		/*--------------------------------cz2004-----------------------*/


		Course cz2004 = new Course("CZ2004", "Human Computer Interaction", "SCSE", 3);
		Index _index4_1= new Index("10140");
		Lesson _lesson4_1_1 = new Lesson("Lecture", 4, 2,1);
		Lesson _lesson4_1_2 = new Lesson("Lecture", 1, 6,1);
		Lesson _lesson4_1_3 = new Lesson("Tutorial", 3, 7,1);
		Lesson _lesson4_1_4 = new Lesson("Lab", 3,3,2);
		
		_index4_1.addToLessons(_lesson4_1_1);
		_index4_1.addToLessons(_lesson4_1_2);
		_index4_1.addToLessons(_lesson4_1_3);
		_index4_1.addToLessons(_lesson4_1_4);
		
		cz2004.addToIndex(_index4_1);
		
		Index _index4_2= new Index("10141");
		Lesson _lesson4_2_1 = new Lesson("Lecture", 4,2,1);
		Lesson _lesson4_2_2 = new Lesson("Lecture", 1, 6,1);
		Lesson _lesson4_2_3 = new Lesson("Tutorial", 4, 8,1);
		Lesson _lesson4_2_4 = new Lesson("Lab", 1,3,2);
		
		_index4_2.addToLessons(_lesson4_2_1);
		_index4_2.addToLessons(_lesson4_2_2);
		_index4_2.addToLessons(_lesson4_2_3);
		_index4_2.addToLessons(_lesson4_2_4);
		
		cz2004.addToIndex(_index4_2);
		/*--------------------------------cz2004-------------------------*/
		
		listofcourses.add(cz2001);
		listofcourses.add(cz2002);
		listofcourses.add(cz2003);
		listofcourses.add(cz2004);
		
		/* ------------------------- end of Course creation ------------------------- */
		
		
		/*-------------------------Utility--------------------------------------*/
		
		fileManager.saveStudentFile(listofstudents); // save student file
		fileManager.saveCoursesFile(listofcourses); // save student file
		fileManager.saveAdminFile(listofAdmin); // save admin file
		System.out.println("File Generated!");
		
		/*-------------------------Utility--------------------------------------*/
		
		
		
//		fileManager fmngr = new fileManager();
//		CourseManager cmngr = new CourseManager();
//		StudentManager smngr = new StudentManager();

		
//		Course cz2001 = new Course("CZ2001", "Algorithms", "SCSE", 3);
//		Index _index1 = new Index("200101");
//		Lesson _lesson1 =  new Lesson("Lab", 0, 3 , 2);
//		Lesson _lesson2 = new Lesson("Lecture", 0, 5, 1);
//		Lesson _lesson3 = new Lesson("Tutorial", 2,5,1);
//		Lesson _lesson4 = new Lesson("Lecture", 4,3,1);
//		
//		_index1.addToLessons(_lesson1);
//		_index1.addToLessons(_lesson2);
//		_index1.addToLessons(_lesson3);
//		_index1.addToLessons(_lesson4);
//		
//		cz2001.addToIndex(_index1);
		
//		
//		/*----------------------------------------------------------------------*/
//		
//		Course cz2001_2 = new Course("CZ2001", "Algorithms", "SCSE", 3);
//		Index _index1_2 = new Index("102");
//		Lesson _lesson1_2 =  new Lesson("Lab", 0, 3 , 2);
//		Lesson _lesson2_2= new Lesson("Lecture", 0, 5, 1);
//		Lesson _lesson3_2 = new Lesson("Tutorial", 2,5,1);
//		Lesson _lesson4_2 = new Lesson("Lecture", 4,3,1);
//		
//		_index1_2.addToLessons(_lesson1_2);
//		_index1_2.addToLessons(_lesson2_2);
//		_index1_2.addToLessons(_lesson3_2);
//		_index1_2.addToLessons(_lesson4_2);
//		
//		cz2001_2.addToIndex(_index1_2);
//		
//		//test
//		
//		cz2001.addToIndex(_index1_2);
//		
//		
//		/*----------------------------------------------------------------------*/
//		
//		
//		Course cz2002 = new Course("CZ2002", "Object-Oriented Design", "SCSE", 3);
//		Index _index2 = new Index("200201");
//		Lesson _lesson5 = new Lesson("Lecture", 1,2,1);
//		Lesson _lesson6 = new Lesson("Lab", 2,3,2);
//		Lesson _lesson7 = new Lesson("Tutorial", 2,8,1);
//		Lesson _lesson8 = new Lesson("Lecture", 4,4,1);
//		
//		_index2.addToLessons(_lesson5);
//		_index2.addToLessons(_lesson6);
//		_index2.addToLessons(_lesson7);
//		_index2.addToLessons(_lesson8);
//		
//		cz2002.addToIndex(_index2);
		
//		Course cz2006 = new Course("CZ2006", "Software Engineering", "SCSE", 3 );
//		Index _index5 = new Index("200501");
//		Lesson _lesson16 = new Lesson("Lecture", 0,2,1);
//		Lesson _lesson17 = new Lesson("Lab", 2,1,2);
//		Lesson _lesson18 = new Lesson("Tutorial", 3,1,1);
//		Lesson _lesson19 = new Lesson("Lecture", 3,6,1);
//		
//		_index5.addToLessons(_lesson16);
//		_index5.addToLessons(_lesson17);
//		_index5.addToLessons(_lesson18);
//		_index5.addToLessons(_lesson19);
//		
//		cz2006.addToIndex(_index5);
//		
//		Course cz2007 = new Course("CZ2007", "Database", "SCSE", 3);
//		Index _index6 = new Index("200701");
//		Index _index7 = new Index("200702");
//		Lesson _lesson20 = new Lesson("Lecture", 0,6,1);
//		Lesson _lesson21 = new Lesson("Tutorial", 1,1,1);
//		Lesson _lesson22 = new Lesson("Lecture", 3,5,1);
//		Lesson _lesson23 = new Lesson("Lecture", 0,6,1);
//		Lesson _lesson24 = new Lesson("Tutorial", 1,1,1);
//		Lesson _lesson25 = new Lesson("Lecture", 3,5,1);
//		_index6.addToLessons(_lesson20);
//		_index6.addToLessons(_lesson21);
//		_index6.addToLessons(_lesson22);
//		_index7.addToLessons(_lesson23);
//		_index7.addToLessons(_lesson24);
//		_index7.addToLessons(_lesson25);
//		cz2007.addToIndex(_index6);
//		cz2007.addToIndex(_index7);
		

	}
}

