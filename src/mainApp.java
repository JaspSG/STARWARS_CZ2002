
import boundary.AdminUI;
import boundary.StudentUI;
import control.CourseManager;
import control.StudentManager;
import control.fileManager;
import entity.Student;
import entity.User;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class mainApp extends User{
	static int currentStudentIndex;
	
	static String loginID;
	static String loginPW;
	
	private static ArrayList<Student> studentList = new ArrayList<Student>();


	public static void main(String[] args) throws Exception  {
		
		CourseManager cmngr = new CourseManager();
		
		studentList = fileManager.loadStudentFile();

		int choice = 0;
		boolean validInput = false;
		Scanner sc = new Scanner(System.in);
		do {
		System.out.println("Enter 1 for Admin, 2 for Student, 3 to test password, 4 to read from dat. file for testing");
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
		
		System.out.println("Enter login ID");
		loginID = sc.nextLine();
		System.out.println("Enter login PW");
		loginPW = sc.nextLine();

		switch (choice) {
		case 1:			
			AdminUI.mainAdminUI();
			break;
		case 2:
			StudentManager smngr = new StudentManager();
			
			for(Student student: studentList) {
				if(student.getLoginID().equals(loginID)) {
					if(student.validateLogin(loginID, loginPW) == true) {
						StudentUI.mainStudentUI();
					}
					else {
						System.out.println("Wrong Login Information");
						break;
					}
					
				}
			}
			break;
		case 3:
			System.out.println("Enter name");
			String username = sc.nextLine();
			System.out.println("Enter Password");
			String password = sc.nextLine();
		//	currentStudentIndex = validateLogin(username,password);
			
			if(currentStudentIndex == -1)
			{
				System.out.println("Wrong password!");
				break;
			}
			System.out.println("Current Student Index is now " + currentStudentIndex);
			break;
		case 4:
			 fileManager fm = new fileManager();
			 studentList = fileManager.loadStudentFile();
			 System.out.println("File Loaded!");
			 
			 for(int i =0; i < studentList.size();i++)
			 {
				 
				 System.out.println(studentList.get(i).getLoginID()); 
				 System.out.println("");
				 System.out.println(studentList.get(i).getLoginPW()); 
				 System.out.println("");
				 
			 }

			break;
		default:
			System.out.println("");
			break;
		}
	} while (choice > 0 && choice < 5);
}
	/*    Admin Course Methods      */
//
//	/**
//	 * UI to handles the adding of course operation done by admin, adding of index to course will be handled
//	 * by addIndexUI. IndexList will be null atm
//	 * @param sc Scanner to read the user (admin) input
//	 */
//	public static void addCourseUI(Scanner sc)
//	{
//		// Get necessary input from the users: name, id, au and index
//		System.out.println("Enter the new course's ID: ");
//		String courseID = sc.nextLine();
//
//		System.out.println("Enter the new course's name: ");
//		String courseName = sc.nextLine();
//
//		System.out.println("Enter the new course's AU: ");
//		int au = sc.nextInt();
//
//		ArrayList<Index> indexArrayList = new ArrayList<Index>();
//
//		// load variable to course object >>> set index to null for now >>> call add index later
//		Course newCourse = new Course(courseName, courseID, au, indexArrayList);
//
//		// confirmation
//		System.out.println("Press Y to Confirm, Press N to Cancel: ");
//		char choice = Character.toUpperCase(sc.next().charAt(0));
//
//		if(choice == 'Y')
//		{
//			// validation to check if course exists
//			if(Course.findCourse(courseID).getCourseID() == null)
//			{
//				// add course
//				boolean result = Admin.addCourse(newCourse);
//				if(result == true) {
//					System.out.println("Course record created. Returning to main UI....\n");
//				} else {
//					System.out.println("Error creating Course, Please contact IT administrator. Returning to main UI....\n");
//				}
//			}
//			else
//			{
//				System.out.println("Course exists. Returning to main UI....\n");
//			}
//		}
//		else
//		{
//			System.out.println("Operation is cancelled. Returning to main UI....\n");
//		}
//	}
//
//	/**
//	 * To add a new index object to the course
//	 * @param sc Scanner to read the user (admin) input
//	 */
//	public static void addIndexUI(Scanner sc, String courseID){
//		// Get necessary input from the users: name, id, au and index
//		// if courseID is null or else use the pass in value
//		if(courseID == null) {
//			System.out.println("Enter the course's ID for the Index Group: ");
//			courseID = sc.nextLine();
//		}
//
//		if(Course.findCourse(courseID).getCourseID() != null) {
//
//			System.out.println("Enter the new Index ID: ");
//			String indexID = sc.nextLine();
//
//			System.out.println("Enter the total size of the Index Group: ");
//			int totalSize = sc.nextInt();
//
//			// call add lesson UI
//			ArrayList<Lesson> lessonArrayList = createLessonUI(sc);
//
//			// load variable to index object
//			Index newIndex = new Index(indexID, totalSize, lessonArrayList);
//
//			// confirmation
//			System.out.println("Press Y to Confirm, Press N to Cancel: ");
//			char choice = Character.toUpperCase(sc.next().charAt(0));
//
//			if (choice == 'Y') {
//				// validation to check if index exists
//				if (/*Course.findIndexObject(indexID).getIndexID() == null*/Index.findIndex(courseID, indexID).getIndexID() == null) {
//					// add course
//					boolean result = Admin.addIndex(courseID, newIndex);
//					if (result) {
//						System.out.println("Index record created. Returning to main UI....\n");
//					} else {
//						System.out.println("Error creating Index, Please contact IT administrator. Returning to main UI....\n");
//					}
//				} else {
//					System.out.println("Index exists. Returning to main UI....\n");
//				}
//			} else {
//				System.out.println("Operation is cancelled. Returning to main UI....\n");
//			}
//		}
//		else{
//			System.out.println("Course ID not found. Returning to main UI....\n");
//		}
//	}
//
//	/**
//	 * to create a form for user to create an array list of lesson
//	 * @param sc Scanner to read the user (admin) input
//	 * @return an array list of lesson that was inputted by the user
//	 */
//	public static ArrayList<Lesson> createLessonUI(Scanner sc)
//	{
//		// create empty array to store
//		ArrayList<Lesson> lessonArrayList = new ArrayList<Lesson>();
//
//		System.out.println("Enter the number of lessons (Lecture+Tutorial+Lab) for the Index Group: ");
//		int numberOfLessons = sc.nextInt();
//
//		for(int i = 0; i < numberOfLessons; i++){
//			// get lesson type
//			System.out.println("\nEnter the lesson's type in term of: \n1. Lecture \n2. Tutorial \n3. Lab: ");
//			boolean checkInput = false;
//			String strLessonType = null;
//			int intLessonType = 0;
//			do{
//				try{
//					intLessonType = sc.nextInt();
//					sc.nextLine();
//					if(intLessonType > 0 && intLessonType < 4){
//						checkInput = true;
//					}
//				} catch (InputMismatchException inputMismatchException) {
//					System.out.println("Please enter within the correct range!");
//					sc.nextLine();
//				}
//			} while(!checkInput);
//			if (intLessonType == 1) {
//				strLessonType = "Lecture";
//			} else if (intLessonType == 2) {
//				strLessonType = "Tutorial";
//			} else if (intLessonType == 3) {
//				strLessonType = "Laboratory";
//			}
//
//			System.out.println("Enter the lesson's start time in term of HH:MM: ");
//			String startTime = sc.nextLine();
//
//			System.out.println("Enter the lesson's end time in term of HH:MM: ");
//			String endTime = sc.nextLine();
//
//			// get lesson day
//			System.out.println("\nEnter the lesson's day in term of: \n1. Monday \n2. Tuesday \n3. Wednesday:" +
//					"\n4. Thursday \n5. Friday \n6. Saturday ");
//			int lessonDay = sc.nextInt();
//
//			Lesson lesson = new Lesson(strLessonType, startTime, endTime, lessonDay);
//			lessonArrayList.add(lesson);
//		}
//		return lessonArrayList;
//	}
//
//	/**
//	 * To update an existing course
//	 * @param sc Scanner to read the user (admin) input
//	 */
//	public static void updateCourseUI(Scanner sc){
//		// initialise
//		Course updateCourse = new Course();
//
//		System.out.println("Enter the Course ID that you wish to update: ");
//		String courseID = sc.nextLine();
//
//		if(Course.findCourse(courseID).getCourseID() != null) {
//			updateCourse = Course.findCourse(courseID);
//			System.out.println("Course record found! Which of the following do you wish to update?: ");
//			System.out.println("1. Course's Name");
//			System.out.println("2. Course's AU Credits");
//			System.out.println("3. Add new index group");
//			System.out.println("4. Remove existing index group");
//			System.out.println("5. Remove course");
//			System.out.println("6. Go back to main menu");
//
//			int choice = 0;
//			do {
//				try {
//					choice = sc.nextInt();
//					if (choice > 0 && choice < 7) {
//						sc.nextLine();
//						break;
//					}
//				} catch (InputMismatchException e) {
//					System.out.println("Enter a valid integer!");
//					sc.nextLine();
//				}
//			} while (true);
//
//			switch (choice){
//				case 1:
//					System.out.println("Current Course's name: " + updateCourse.getCourseName());
//					System.out.println("Enter the new Course's name: ");
//					String updateCourseName = sc.nextLine();
//					updateCourse.setCourseName(updateCourseName);
//					boolean result = Admin.updateCourse(updateCourse);
//					if(result == true) {
//						System.out.println("Course's name updated. Returning to main UI....\n");
//					} else {
//						System.out.println("Error updating Course's name, Please contact IT administrator. Returning to main UI....\n");
//					}
//					break;
//				case 2:
//					System.out.println("Current Course's AU Credits");
//					System.out.println("Enter the new Course's AU Credits");
//					int updateAUCredits = 0;
//					do {
//						try {
//							updateAUCredits = sc.nextInt();
//							if (updateAUCredits>0) {
//								sc.nextLine();
//								break;
//							}
//						} catch (InputMismatchException e) {
//							System.out.println("Enter a valid integer!");
//							sc.nextLine();
//						}
//					} while (true);
//					updateCourse.setAu(updateAUCredits);
//					boolean result1 = Admin.updateCourse(updateCourse);
//					if(result1 == true) {
//						System.out.println("Course's AU updated. Returning to main UI....\n");
//					} else {
//						System.out.println("Error updating Course's AU, Please contact IT administrator. Returning to main UI....\n");
//					}
//				case 3:
//					addIndexUI(sc, courseID);
//				case 4:
//					ArrayList<Index> updateCourseIndex = updateCourse.getIndex();
//					for(int i = 0; i < updateCourseIndex.size(); i++){
//						System.out.println(updateCourseIndex.get(i).getIndexID());
//					}
//					System.out.println("Enter the index group to remove from course: ");
//					String removeIndexID = sc.nextLine();
//					if(Index.findIndex(courseID, removeIndexID).getIndexID() != null){
//						boolean result3 = Index.removeIndex(courseID, removeIndexID);
//						if(result3 == true) {
//							System.out.println("Remove index successfully. Returning to main UI....\n");
//						} else {
//							System.out.println("Error removing index, Please contact IT administrator. Returning to main UI....\n");
//						}
//					}
//					else{
//						System.out.println("Invalid index ID, Returning to main menu");
//					}
//					break;
//				case 5:
//					System.out.println("Press Y to Confirm delete, Press N to Cancel: ");
//					char confirm = Character.toUpperCase(sc.next().charAt(0));
//
//					if(confirm == 'Y')
//					{
//						boolean result4 = Course.removeCourse(updateCourse.getCourseID());
//						if(result4 == true) {
//							System.out.println("Remove Course Successfully.  Returning to main UI....\n");
//						} else {
//							System.out.println("Error removing Course, Please contact IT administrator. Returning to main UI....\n");
//						}
//
//					}
//					else
//					{
//						System.out.println("Operation is cancelled. Returning to main UI....\n");
//					}
//					break;
//				default:
//					System.out.println("Returning to main UI....\n");
//					break;
//			}
//		}
//		else{
//			System.out.println("CourseID do not exists. Returning to main UI....\n");
//		}
//	}
//
//	/**
//	 * To create a form for user to add an student
//	 * @param sc Scanner to read the user (admin) input
//	 * @throws NoSuchAlgorithmException This exception is thrown when a particular cryptographic algorithm is
//	 * requested but is not available in the environment.
//	 */
//	public static void addStudentUI(Scanner sc) throws NoSuchAlgorithmException {
//
//		// get input from the user
//		System.out.print("Enter the new student's name: ");
//		String studentName = sc.nextLine();
//
//		System.out.print("Enter the new student's matriculation number: ");
//		String matriculationNumber = sc.nextLine();
//
//		System.out.print("Enter the new student's nationality: ");
//		String nationality = sc.nextLine();
//
//		System.out.print("Enter the new student's major: ");
//		String major = sc.nextLine();
//
//		System.out.print("Enter the new student's gender(M/F): ");
//		char gender = sc.next().charAt(0);
//
//		System.out.print("Enter the new student's year of study: ");
//		int yearOfStudy = sc.nextInt();
//
//		System.out.print("Enter the new student's loginID: ");
//		String loginId = sc.nextLine();
//
//		System.out.print("Enter the new student's loginPW: ");
//		String loginPW = sc.nextLine();
//		loginPW = User.hashString(loginPW);
//
//		// insert object into the file
//		Student newStudent = new Student(studentName, matriculationNumber, nationality, major, gender, yearOfStudy, loginId, loginPW);
//
//		// confirmation
//		System.out.println("Press Y to Confirm, Press N to Cancel: ");
//		char choice = Character.toUpperCase(sc.next().charAt(0));
//
//		if(choice == 'Y')
//		{
//			// validation to check if index exists
//			if(Student.findStudent(matriculationNumber).getMatricNumber() == null)
//			{
//				// add student
//				boolean result = Admin.addStudent(newStudent);
//				if(result == true) {
//					System.out.println("Student record created. Returning to main UI....\n");
//				} else {
//					System.out.println("Error creating Student, Please contact IT administrator. Returning to main UI....\n");
//				}
//			}
//			else
//			{
//				System.out.println("Student exists. Returning to main UI....\n");
//			}
//		}
//		else
//		{
//			System.out.println("Operation is cancelled. Returning to main UI....\n");
//		}
//	}
//
//	/**
//	 * To create a form to get what index ID (and courseID) that the user(admin) want to print
//	 * @param sc Scanner to read the user (admin) input
//	 */
//	public static void printIndexStudentListUI(Scanner sc){
//		System.out.print("Enter the index's Course ID: ");
//		String courseID = sc.nextLine();
//
//		System.out.print("Enter the index ID: ");
//		String indexID = sc.nextLine();
//
//		if(Course.findCourse(courseID).getCourseID() != null && Index.findIndex(courseID, indexID).getIndexID() != null){
//			Admin.printIndexStudentList(courseID, indexID);
//		}
//		System.out.println("Returning to main UI....\n");
//	}
//	/**
//	 * To create a form to get what course ID that the user(admin) want to print
//	 * @param sc Scanner to read the user (admin) input
//	 */
//	public static void printCourseStudentListUI(Scanner sc){
//		System.out.print("Enter the index's Course ID: ");
//		String courseID = sc.nextLine();
//
//		if(Course.findCourse(courseID).getCourseID() != null){
//			Admin.printCourseStudentList(courseID);
//		}
//		System.out.println("Returning to main UI....\n");
//	}
	/*    Admin UI Case Statement   */
//	public static void adminMenu(Scanner sc) throws NoSuchAlgorithmException {
//		int choice = 0;
//		boolean validInput = false;
//
//		do {
//			System.out.println("");
//			System.out.println("Welcome, Admin");
//			System.out.println("What do you want to do? ");
//			System.out.println("1. Add a new course");
//			System.out.println("2. Add a new index group");
//			System.out.println("3. Update existing course");
//			System.out.println("4. Check vacancy for an existing index group");
//			System.out.println("5. Add a new student");
//			System.out.println("6. Edit student access periods");
//			System.out.println("7. Print list of students by index group number");
//			System.out.println("8. Print list of students by course");
//			System.out.println("9. Logout");
//
//			do {
//				try {
//					choice = sc.nextInt();
//					sc.nextLine();
//				if (choice >= 1) {
//					validInput = true;
//					}
//				} catch (InputMismatchException e) {
//					System.out.println("Enter a valid integer!");
//					sc.nextLine();
//				}
//			} while (!validInput);
//
//			switch (choice) {
//			case 1:
//				System.out.println("1. Add a new course");
//				//addCourseUI(sc);
//				break;
//			case 2:
//				System.out.println("2. Add a new index group");
//				//addIndexUI(sc, null);
//				break;
//			case 3:
//				System.out.println("3. Update existing course");
//				//updateCourseUI(sc);
//				break;
//			case 4:
//				System.out.println("4. Check vacancy for an existing index group");
//				break;
//			case 5:
//				System.out.println("5. Add a new student");
//				//addStudentUI(sc);
//				break;
//			case 6:
//				System.out.println("6. Edit student access periods");
//				break;
//			case 7:
//				System.out.println("7. Print list of students by index group number");
//				//printIndexStudentListUI(sc);
//				break;
//			case 8:
//				System.out.println("8. Print list of students by course");
//				//printCourseStudentListUI(sc);
//				break;
//			default:
//				System.out.println("");
//				break;
//			}
//		} while (choice > 0 && choice < 9);
//	}
//
//
//	public static void studentMenu(Scanner sc) {
//		int choice = 0;
//		boolean validInput = false;
//		String courseID,tutGroup;
//		StudentManager StuManager = new StudentManager(currentStudentIndex);
//
//		do {
//			System.out.println("");
//			System.out.println("Welcome, Student") ;
//			System.out.println("What do you want to do? ");
//			System.out.println("1. Add a course");
//			System.out.println("2. Drop course");
//			System.out.println("3. Print courses registered");
//			System.out.println("4. Check vacancies for an index group number");
//			System.out.println("5. Change index group number of course");
//			System.out.println("6. Swap index group number with another student");
//			System.out.println("7. Logout");
//
//			do {
//				try {
//					choice = sc.nextInt();
//				if (choice >= 1) {
//					validInput = true;
//					sc.nextLine();
//					}
//				} catch (InputMismatchException e) {
//					System.out.println("Enter a valid integer!");
//					sc.nextLine();
//				}
//			} while (!validInput);
//			validInput = false;
//
//			switch (choice) {
//			case 1:
//				System.out.println("1. Add a course");
//				System.out.println("Enter Course ID: ");
//				courseID = sc.nextLine();
//				System.out.println("Enter Tut Group: ");
//				tutGroup = sc.nextLine();
//				StuManager.addCourse(courseID,tutGroup);
//				break;
//			case 2:
//				System.out.println("2. Drop course");
//				break;
//			case 3:
//				System.out.println("Printing courses registered");
//				StuManager.printCourseRegistered();
//				break;
//			case 4:
//				System.out.println("4. Check vacancies for an index group number");
//				break;
//			case 5:
//				System.out.println("5. Change index group number of course");
//				break;
//			case 6:
//				System.out.println("6. Swap index group number with another student");
//				break;
//			default:
//				System.out.println("");
//				break;
//			}
//		} while (choice > 0 && choice < 7);
//
//
//		System.out.println("test");
//
//	}
}
