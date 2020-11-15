package boundary;

import java.util.InputMismatchException;

import java.util.Scanner;

import control.StudentManager;

public class StudentUI {

	static StudentManager stmngr = new StudentManager();
	static int choice;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

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
			sc.nextLine();

			switch (choice) {

			case 1:
				break;

			case 2:
				break;

			case 3:
				break;

			case 4:
				System.out.println("Enter Course ID to check: ");
				String courseID = sc.nextLine().toUpperCase();
				System.out.println("Enter Index ID to check: ");
				String indexID = sc.nextLine();
				stmngr.printVacanciesAvaliable(courseID, indexID);
				System.out.println();
				break;

			case 5:
				break;

			case 6:
				break;

			case 7:
				break;
				
			default:
				System.out.println("Please only enter the choices shown\n");

			}
		} while (choice != 7);

		System.out.println("STARS Exiting..");

	}

}
