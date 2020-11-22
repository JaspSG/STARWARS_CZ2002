package boundary;

import control.CourseManager;
import control.StudentManager;
import entity.Course;
import entity.Index;
import entity.Student;

import java.util.ArrayList;
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
				Student currentStudent = stmngr.findCurrentStudent();
				System.out.println("Printing list of course available for index change");
				for(int i = 0; i < currentStudent.getCourseEnrolled().size();i++)
				{
					 System.out.println(currentStudent.getCourseEnrolled().get(i).getCourseID()+ "\n");
		        }
				System.out.println("Enter the course that you want to change index:");
		        String changeCourseID = sc.nextLine().toUpperCase();
		        
		        
		        //check if course entered is valid
		        boolean checkCourseEntered = false;
		        for(int i = 0; i < currentStudent.getCourseEnrolled().size();i++ )
		        {
		        	if(changeCourseID.equals(currentStudent.getCourseEnrolled().get(i).getCourseID()))
		        	{
		        		checkCourseEntered = true;
		        		break;
		        	}
		        	else
		        	{
		        		checkCourseEntered = false;
		        	}
		        }
		        
		        if(checkCourseEntered == false)
		        {
		        	System.out.println("Invalid Course Entered!");
		        	break;
		        }
		        
		       //course entered is valid, now we get index available for change
		       ArrayList<Course> courseList = new ArrayList<Course>();
		       ArrayList<Index> indexList = new ArrayList<Index>();
		       courseList = CourseManager.getListOfCourses();
		       
		       for(int  i = 0; i < courseList.size(); i++)
		        {
		        	if(changeCourseID.equals(courseList.get(i).getCourseID()))
		        	{
		        		indexList = courseList.get(i).getIndex();
		        		break;
		        	}
		      
		        }
		       
		        System.out.println("Printing list of index available for the course" + "\n");
		        
		        for (int i = 0; i < indexList.size(); i++)
		        {
		        	 System.out.println(indexList.get(i).getIndexID() + "\n");
		        }
		        
		        System.out.println("Enter the index that you want to change to: ");
		        String indexToChange = sc.nextLine();
			    boolean checkChangeSuccess = stmngr.changeIndex(changeCourseID, indexToChange);
			    
			    if(checkChangeSuccess == false)
			    {
			    	System.out.println("Clash in timetable, change is not possible");
			    }
			    else
			    {
			    	System.out.println("Index has been changed");
			    }
				break;

			case 6:
				Student currentStudentSwap = stmngr.findCurrentStudent();
				System.out.println("Printing list of course available for index swap");
				for(int i = 0; i < currentStudentSwap.getCourseEnrolled().size();i++)
				{
					 System.out.println(currentStudentSwap.getCourseEnrolled().get(i).getCourseID()+ "\n");
		        }
				System.out.println("Enter the course that you want to swap index:");
		        String swapCourseID = sc.nextLine().toUpperCase();
		        
		        
		        //check if course entered is valid
		        boolean checkCourseEnteredSwap = false;
		        for(int i = 0; i < currentStudentSwap.getCourseEnrolled().size();i++ )
		        {
		        	if(swapCourseID.equals(currentStudentSwap.getCourseEnrolled().get(i).getCourseID()))
		        	{
		        		checkCourseEnteredSwap = true;
		        		break;
		        	}
		        	else
		        	{
		        		checkCourseEnteredSwap = false;
		        	}
		        }
		        
		        if(checkCourseEnteredSwap == false)
		        {
		        	System.out.println("Invalid Course Entered!");
		        	break;
		        }
		        
		       //course entered is valid, now we get index available for change
		       ArrayList<Course> courseListSwap = new ArrayList<Course>();
		       ArrayList<Index> indexListSwap = new ArrayList<Index>();
		       courseListSwap = CourseManager.getListOfCourses();
		       
		       for(int  i = 0; i < courseListSwap.size(); i++)
		        {
		        	if(swapCourseID.equals(courseListSwap.get(i).getCourseID()))
		        	{
		        		indexListSwap = courseListSwap.get(i).getIndex();
		        		break;
		        	}
		      
		        }
		       
		        System.out.println("Printing list of index available for the course" + "\n");
		        
		        for (int i = 0; i < indexListSwap.size(); i++)
		        {
		        	 System.out.println(indexListSwap.get(i).getIndexID() + "\n");
		        }
		        
		        System.out.println("Enter the index that you want to swap: ");
		        String indexToSwap = sc.nextLine();
		        
		        //ask who does he want to swap with
		        ArrayList<Student> listOfStudents = StudentManager.getListOfStudents();
		        System.out.println("Printing list of students for index swap");
		        for(int i = 0; i < listOfStudents.size();i++)
		        {
		        	if(!currentStudentSwap.getName().equals(listOfStudents.get(i).getName()))
		        	{
		        		 System.out.println(listOfStudents.get(i).getName()+ "\n");
		        	}
		        	
		        }
		        
		        System.out.println("Enter name of student that you want to swap with: " + "\n");
		        String studentNameSwap = sc.nextLine();
		        
		   
				boolean checkSwapSuccess = stmngr.swapIndex(swapCourseID, indexToSwap, studentNameSwap);
				if(checkSwapSuccess == true)
				{
					System.out.println("Index swapped");
				}
				else
				{
					System.out.println("Index was not swapped");
				}

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
