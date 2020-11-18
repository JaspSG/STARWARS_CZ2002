import java.util.ArrayList;

<<<<<<< Updated upstream
import control.fileManager;
=======
import control.CourseManager;
import control.FileManager;
>>>>>>> Stashed changes
import entity.Course;
import entity.Index;
import entity.Student;

public class testingfile {

	public static void main(String[] args) throws Exception {
		
		
		FileManager fmngr = new FileManager();
		
		ArrayList<Student> listofstudents = new ArrayList<Student>();
		
		Student _student1 = new Student("John Cena", "A1800123B", "Singaporean", "SCSE", 'M', 1, "loginID_1", "loginPW_1");
		
		Student _student2 = new Student("TRUMPET", "C1283713D", "Singaporean", "SCSE", 'M', 3, "loginID_2", "loginPW_2");
		
		Student _student3 = new Student("BIDEN", "E2938173F", "Malaysian", "EEE", 'F', 2, "loginID_3", "loginPW_3");
		
		Student _student4 = new Student("BEIBER", "G2938717H", "Myanmar", "BASE", 'F', 5, "loginID_4", "loginPW_4");
		
		Student _student5 = new Student("MICHELLE", "I29836721J", "Chinese", "SESE", 'M', 2, "loginID_5", "loginPW_5");
		
		Student _student6 = new Student("RONALD", "K1928363L", "Chinese", "SEEE", 'F', 2, "loginID_6", "loginPW_6");
		
		Student _student7 = new Student("Ya Fei", "M12345678N", "Malaysian", "SHEH", 'M', 2, "loginID_7", "loginPW_7");
		
		Student _student8 = new Student("Wei Run", "O98765432P", "Chinese", "CEES", 'M', 2, "loginID_8", "loginPW_8");
		
		Student _student9 = new Student("Alex Tan", "Q34123214R", "American", "SQES", 'M', 2, "loginID_9", "loginPW_9");
		
		Student _student10 = new Student("Wonder Fei", "S29836721T", "British", "SXGE", 'M', 2, "loginID_10", "loginPW_10");
		
		
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
		
		Index _index1 = new Index("SSP2");
		Index _index2 = new Index("SP4");
		Index _index3 = new Index("FS8");
		Index _index4 = new Index("FS3");
		Index _index5 = new Index("FP5");
		
		ArrayList<Course> listofcourses = new ArrayList<Course>();
		
		Course _course1 = new Course("DATA STRUCTURES", "CZ1007", 3);

		Course _course2 = new Course("ENGINEERING MATHEMATICS 1", "CZ1011", 3);
		
		Course _course3 = new Course("ENGINEERING MATHEMATICS 2", "CZ1012", 3);
		
		Course _course4 = new Course("Digital Logic", "CZ1105", 3);
		
		Course _course5 = new Course("Computer Organisation & Architechture", "CZ1106", 3);
		
		Course _course6 = new Course("Introduction to Databases", "CZ2007", 3);
		
		listofcourses.add(_course6);
		listofcourses.add(_course5);
		listofcourses.add(_course4);
		listofcourses.add(_course3);
		listofcourses.add(_course2);
		listofcourses.add(_course1);
		
		_course6.setIndex(listofindex);
		_course5.setIndex(listofindex);
		_course4.setIndex(listofindex);
		_course3.setIndex(listofindex);
		_course2.setIndex(listofindex);
		_course1.setIndex(listofindex);
		
<<<<<<< Updated upstream
=======
		FileManager.saveStudentFile(listofstudents); //save student file
		FileManager.saveCoursesFile(listofcourses); //save student file
		
		//ArrayList<Course> loaded_listofcourses = new ArrayList<Course>();
		//loaded_listofcourses = fileManager.loadCoursesFile(); //save courses file
>>>>>>> Stashed changes
		
		fmngr.saveStudentFile(listofstudents); //save student file
		
		fmngr.saveCoursesFile(listofcourses); //save courses file
		
		//Use corresponding set methods to set the variables you want to test
		
		//ArrayList<Student> reloaded_listofstudents = fmngr.loadStudentFile(); // load student file
		
		//reloaded_listofstudents.get(0).setName("john");

		//System.out.println(_secondlistofstudents.get(0).getName());
		
		
		
		
	}
	
}
