package boundary;

import java.util.InputMismatchException;
import java.util.Scanner;

import control.StudentManager;

public class StudentUI {

	// StudentManager stmngr = new StudentManager();
	static Scanner sc = new Scanner(System.in);
	static int choice;

	public static void main(String[] args) {

		do {

			System.out.println("Welcome Student\nPlease Select one of functions:");
			System.out.println("1. Add Course");
			System.out.println("2. Drop Course");
			System.out.println("3. Check/Print Courses Registered");
			System.out.println("4. Check Vacancies Available");
			System.out.println("5. Change Index Number of Course");
			System.out.println("6. Swop Index Number with Another Student");
			System.out.println("7. Exit");

			try {
				choice = sc.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("Please only enter the choices shown");
				choice = sc.nextInt();
			}

			switch (choice) {

			case 1:
				break;

			case 2:
				break;

			case 3:
				break;

			case 4:
				break;

			case 5:
				break;

			case 6:
				break;

			case 7:
				break;
				
			case 8:
				break;

			default:
				System.out.println("Please only enter the choices shown\n");

			}
		} while (choice != 8);

		System.out.println("STARS Exiting..");

//		
//		switch (choice) {
//		case 1:
//			adminMenu(sc);
//			break;
//		case 2:
//			studentMenu(sc);
//			break;
//		case 3:
//			System.out.println("Enter name");
//			String username =sc.nextLine();
//			System.out.println("Enter Password");
//			String password = sc.nextLine();
//			currentStudentIndex = validateLogin(username,password);
//			
//			if(currentStudentIndex == -1)
//			{
//				System.out.println("Wrong password!");
//				break;
//			}
//			System.out.println("Current Student Index is now " + currentStudentIndex);
//			break;
//		case 4:
//			 fileManager fm = new fileManager();
//			 studentList = fileManager.loadStudentFile();
//			 System.out.println("File Loaded!");
//			 
//			 for(int i =0; i < studentList.size();i++)
//			 {
//				 
//				 System.out.println(studentList.get(i).getLoginID()); 
//				 System.out.println("");
//				 System.out.println(studentList.get(i).getLoginPW()); 
//				 System.out.println("");
//				 
//			 }
//
//			break;
//		default:
//			System.out.println("");
//			break;
//		}

	}

}
