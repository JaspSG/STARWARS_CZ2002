package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
// scanner object
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class Admin extends User{

    public boolean addStudent() {
        // initialise result = false
        boolean result = false;

        // initialise scanner object
        Scanner sc = new Scanner(System.in);

        // initialise variable and scanner object
        System.out.print("Enter the new student's name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter the new student's matriculation number: ");
        String matriculationNumber = sc.nextLine();

        System.out.print("Enter the new student's nationality: ");
        String nationality = sc.nextLine();

        System.out.print("Enter the new student's loginID: ");
        String loginId = sc.nextLine();

        System.out.print("Enter the new student's loginPW: ");
        String loginPW = sc.nextLine();

        System.out.print("Enter the new student's gender(M/F): ");
        char gender = sc.next().charAt(0);

        System.out.print("Enter the new student's year of study: ");
        int yearOfStudy = sc.nextInt();

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm:ss", Locale.ENGLISH);

        System.out.print(" Enter the new student's access start time in the following format (dd/MM/yy HH:mm:ss): ");

        System.out.print(" Enter the new student's access end time in the following format (dd/MM/yy HH:mm:ss): ");

        // https://stackoverflow.com/questions/5301226/convert-string-to-calendar-object-in-java

	    return result; // temp value

    }

    public boolean addCourse() {
        return true; // temp value
    }

    public boolean updateCourse() {
        return true; // temp value
    }

    public ArrayList<Student> printStudentList() {
        return null;
    }

    public ArrayList<Student> printStudentEnrolled(Course course) {
        return null;
    }
}
