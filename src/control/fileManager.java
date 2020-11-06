package control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import entity.Course;
import entity.Student;

public class fileManager {
	

	
	final static String outStudentFileName = "StudentFile";
	final static String outCoursesFileName = "CoursesFile";
	
	//STUDENT OBJECTS READER
	
	public static void saveStudentFile(ArrayList<Student> listOfStudent) throws Exception {
		
		String outputfilepath = String.format("src\\\\%s.ser", outStudentFileName);
		
	    FileOutputStream fileOut =
	    new FileOutputStream(outputfilepath);
	    ObjectOutputStream out = new ObjectOutputStream(fileOut);
	    out.writeObject(listOfStudent);
	    out.close();
	    fileOut.close();
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Student> loadStudentFile() {
		
		String filepath = String.format("src\\\\%s.ser", outStudentFileName);
		ArrayList<Student> value = new ArrayList<Student>();
		
	      try {
	          FileInputStream fileIn = new FileInputStream(filepath);
	          ObjectInputStream in = new ObjectInputStream(fileIn);
	          value = (ArrayList<Student>) in.readObject();
	          in.close();
	          fileIn.close();
	       } catch (IOException i) {
	          i.printStackTrace();
	       } catch (ClassNotFoundException c) {
	          System.out.println("Student class not found");
	          c.printStackTrace();
	       }
	      
	      return value;
	}
	
	// END OF STUDENT OBJECT READER
	
	// COURSE OBJECT READER
	
	public static void saveCoursesFile(ArrayList<Course> listOfCourses) throws Exception {
		
		String outputfilepath = String.format("src\\\\%s.ser", outCoursesFileName);
		
	    FileOutputStream fileOut =
	    new FileOutputStream(outputfilepath);
	    ObjectOutputStream out = new ObjectOutputStream(fileOut);
	    out.writeObject(listOfCourses);
	    out.close();
	    fileOut.close();
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Course> loadCoursesFile() {
		
		String filepath = String.format("src\\\\%s.ser", outCoursesFileName);
		ArrayList<Course> value = new ArrayList<Course>();
		
	      try {
	          FileInputStream fileIn = new FileInputStream(filepath);
	          ObjectInputStream in = new ObjectInputStream(fileIn);
	          value = (ArrayList<Course>) in.readObject();
	          in.close();
	          fileIn.close();
	       } catch (IOException i) {
	          i.printStackTrace();
	       } catch (ClassNotFoundException c) {
	          System.out.println("Course class not found");
	          c.printStackTrace();
	       }
	      
	      return value;
	}
	
	// END OF COURSE OBJECT READER
	
	


	
}
