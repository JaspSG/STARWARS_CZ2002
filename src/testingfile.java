import java.util.ArrayList;

import control.fileManager;
import entity.Student;

public class testingfile {

	public static void main(String[] args) throws Exception {
		
		
		fileManager fmngr = new fileManager();
		
		ArrayList<Student> listofstudents = new ArrayList<Student>();
		
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		Student student4 = new Student();
		Student student5 = new Student();
		
		
		listofstudents.add(student1);
		listofstudents.add(student2);
		listofstudents.add(student3);
		listofstudents.add(student4);
		listofstudents.add(student5);
		
		fmngr.saveStudentFile(listofstudents); //save student file
		
		ArrayList<Student> _secondlistofstudents = fmngr.loadStudentFile(); // load student file
		
		_secondlistofstudents.get(0).setName("john");
		
		System.out.println(_secondlistofstudents.get(0).getName());
		
		
		
		
	}
	
}
