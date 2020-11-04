import java.util.InputMismatchException;
import java.util.Scanner;

public class mainApp {

	public static void main(String[] args) {

		int choice = 0;

		Scanner sc = new Scanner(System.in);
		do {
		System.out.println("Enter 1 for Admin, 2 for Student");
		choice = sc.nextInt();
		if (choice == 1)
		
		{
			adminMenu(sc);
		}
		else if (choice == 2)
		{
			studentMenu(sc);
		}
		
	} while (choice >= 1  && choice <= 2);
	}
	
	public static void adminMenu(Scanner sc) {
		int choice = 0;
		boolean validInput = false;

		do {
			System.out.println("");
			System.out.println("Welcome, Admin");
			System.out.println("What do you want to do? ");
			System.out.println("1. Add a new course");
			System.out.println("2. Add a new index group");
			System.out.println("3. Update existing course");
			System.out.println("4. Check vacancy for an existing index group");
			System.out.println("5. Add a new student");
			System.out.println("6. Edit student access periods");
			System.out.println("7. Print list of students by index group number");
			System.out.println("8. Print list of students by course");
			System.out.println("9. Logout");

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
				System.out.println("1. Add a new course");
				break;
			case 2:
				System.out.println("2. Add a new index group");
				break;
			case 3:
				System.out.println("3. Update existing course");
				break;
			case 4:
				System.out.println("4. Check vacancy for an existing index group");
				break;
			case 5:
				System.out.println("5. Add a new student");
				break;
			case 6:
				System.out.println("6. Edit student access periods");
				break;
			case 7:
				System.out.println("7. Print list of students by index group number");
				break;
			case 8:
				System.out.println("8. Print list of students by course");
				break;
			default:
				System.out.println("");
				break;
			}
		} while (choice > 0 && choice < 9);
	}
	
	
	public static void studentMenu(Scanner sc) {
		int choice = 0;
		boolean validInput = false;

		do {
			System.out.println("");
			System.out.println("Welcome, Student") ;
			System.out.println("What do you want to do? ");
			System.out.println("1. Add a course");
			System.out.println("2. Drop course");
			System.out.println("3. Print courses registered");
			System.out.println("4. Check vacancies for an index group number");
			System.out.println("5. Change index group number of course");
			System.out.println("6. Swap index group number with another student");
			System.out.println("7. Logout");
			
			do {
				try {
					choice = sc.nextInt();
				if (choice >= 1) {
					validInput = true;
					sc.nextLine();
					}
				} catch (InputMismatchException e) {
					System.out.println("Enter a valid integer!");
					sc.nextLine();
				}
			} while (!validInput);
			validInput = false;

			switch (choice) {
			case 1:
				System.out.println("1. Register a course");
				break;
			case 2:
				System.out.println("2. Drop course");
				break;
			case 3:
				System.out.println("3. Print courses registered");
				break;
			case 4:
				System.out.println("4. Check vacancies for an index group number");
				break;
			case 5:
				System.out.println("5. Change index group number of course");
				break;
			case 6:
				System.out.println("6. Swap index group number with another student");
				break;
			default:
				System.out.println("");
				break;
			}
		} while (choice > 0 && choice < 7);

		
		System.out.println("test");

	}
}
