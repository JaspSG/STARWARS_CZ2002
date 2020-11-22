import boundary.AdminUI;
import boundary.StudentUI;
import control.CourseManager;
import control.StudentManager;
import control.fileManager;
import entity.Admin;
import entity.Student;
import entity.User;

import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class mainApp extends User {
	static int currentStudentIndex;

	static String loginID;
	static String loginPW;

//	private static ArrayList<Student> studentList = new ArrayList<Student>();

	public static void main(String[] args) throws Exception {

		Console console = System.console();

		int choice = 0;
		boolean validInput = false;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println(
					"Enter 1 for Admin, 2 for Student, 3 to exit");
			do {
				try {
					choice = sc.nextInt();
					sc.nextLine();
					if (choice >= 1) {
						validInput = true;
					}
				} catch (InputMismatchException e) {
					System.out.println("Enter a valid integer!");
					sc.nextLine();
				}
			} while (!validInput);


			switch (choice) {
			case 1:
				System.out.println("Enter login ID");
				loginID = sc.nextLine();
				System.out.println("Enter login PW");
				loginPW = sc.nextLine();
				//loginPW = new String(console.readPassword("Please enter login password."));
				ArrayList<Admin> adminList = fileManager.loadAdminFile();
				for(Admin admin : adminList){
					if(admin.getLoginID().equals(loginID)){
						if(admin.validateLogin(loginID, loginPW)){
							AdminUI.mainAdminUI();
							break;
						} else {
							System.out.println("Wrong Login Information");
							break;
						}
					} else {
						System.out.println("Admin not found");
						break;
					}
				}
				//System.out.println("Admin Not Found");
				break;
			case 2:
				System.out.println("Enter login ID");
				loginID = sc.nextLine();
				System.out.println("Enter login PW");
				loginPW = sc.nextLine();
				//loginPW = new String(console.readPassword("Please enter login password."));
				StudentManager smngr = new StudentManager();
				ArrayList<Student> studentList = new ArrayList<Student>();
				studentList = smngr.getListOfStudents();

				for (Student student : studentList) {
					if (student.getLoginID().equals(loginID)) {
						if (student.validateLogin(loginID, loginPW) == true) {

							if(student.accessPeriodValidity()) {
								StudentUI.mainStudentUI(loginID);
								break;
								
							}
							else{
								System.out.println("Invalid Access Period Information");
								break;
							}
						} else {
							System.out.println("Wrong Login Information");
							break;
						}

					}
					else {
						System.out.println("Student Not Found");
					}
				}
				break;
			case 3:
				break;
			default:
				System.out.println("");
				break;
			}
		} while (choice != 3);
		
		System.out.println("System Exiting...");
	}

}
