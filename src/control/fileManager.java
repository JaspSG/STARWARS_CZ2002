package control;

import entity.Admin;
import entity.Course;
import entity.Student;

import java.io.*;
import java.util.ArrayList;

public class fileManager {

	final static String OUTSTUDENTFILENAME = "StudentFile";
	final static String OUTCOURSESFILENAME = "CoursesFile";
	final static String OUTADMINFILENAME = "AdminFile";

	// STUDENT OBJECTS READER

	public static void saveStudentFile(ArrayList<Student> listOfStudent) throws Exception {

		String outputfilepath = String.format("src\\\\%s.ser", OUTSTUDENTFILENAME);

		FileOutputStream fileOut = new FileOutputStream(outputfilepath);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(listOfStudent);
		out.close();
		fileOut.close();
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Student> loadStudentFile() {

		String filepath = String.format("src\\\\%s.ser", OUTSTUDENTFILENAME);
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

		String outputfilepath = String.format("src\\\\%s.ser", OUTCOURSESFILENAME);

		FileOutputStream fileOut = new FileOutputStream(outputfilepath);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(listOfCourses);
		out.close();
		fileOut.close();
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Course> loadCoursesFile() {

		String filepath = String.format("src\\\\%s.ser", OUTCOURSESFILENAME);
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

	// ADMIN OBJECT READER

	public static void saveAdminFile(ArrayList<Admin> listOfAdmin) throws Exception {

		String outputfilepath = String.format("src\\\\%s.ser", OUTADMINFILENAME);

		FileOutputStream fileOut = new FileOutputStream(outputfilepath);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(listOfAdmin);
		out.close();
		fileOut.close();
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<Admin> loadAdminFile() {

		String filepath = String.format("src\\\\%s.ser", OUTADMINFILENAME);
		ArrayList<Admin> value = new ArrayList<Admin>();

		try {
			FileInputStream fileIn = new FileInputStream(filepath);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			value = (ArrayList<Admin>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
		} catch (ClassNotFoundException c) {
			System.out.println("Admin class not found");
			c.printStackTrace();
		}

		return value;
	}

	// END OF Admin OBJECT READER
}
