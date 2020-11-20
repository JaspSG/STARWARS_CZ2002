package boundary;

import control.StudentManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentUI {

	public static void mainStudentUI(String username) {

		StudentManager stmngr = new StudentManager(username);
		int choice;
		String courseID,indexID;
		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("Welcome Student\nPlease Select one of functions:");
			System.out.println("1. Add Course");
			System.out.println("2. Drop Course");
			System.out.println("3. Check/Print Courses Registered");
			System.out.println("4. Check Vacancies Available");
			System.out.println("5. Change Index Number of Course");
			System.out.println("6. Swop Index Number with Another Student");
			System.out.println("7. Print Timetable");
			System.out.println("8. Exit");

			try {
				choice = sc.nextInt();
			} catch (InputMismatchException ex) {
				System.out.println("Please only enter the choices shown");
				choice = sc.nextInt();
			}
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.println("Enter Course ID to add: ");
				courseID = sc.nextLine().toUpperCase();
				System.out.println("Enter Index ID to add: ");
				indexID = sc.nextLine();
				stmngr.addCourse(courseID, indexID);
				break;

			case 2:
				System.out.println("Enter Course ID to drop: ");
				courseID = sc.nextLine().toUpperCase();
				stmngr.dropCourse(courseID);
				break;

			case 3:
				System.out.println("Printing Registered Courses!");
				stmngr.printCourseRegistered();
				break;

			case 4:
				System.out.println("Enter Course ID to check: ");
				courseID = sc.nextLine().toUpperCase();
				System.out.println("Enter Index ID to check: ");
				indexID = sc.nextLine();
				stmngr.printVacanciesAvaliable(courseID, indexID);
				System.out.println();
				break;

			case 5:
				break;

			case 6:
				break;

			case 7:
				stmngr.printSchedule();
				break;
				
			case 8:
				break;

			default:
				System.out.println("Please only enter the choices shown\n");

			}
		} while (choice != 8);

		System.out.println("STARS Exiting..");

	}

}
