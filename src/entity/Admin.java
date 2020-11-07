package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
// scanner object
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

import static control.fileManager.*;


public class Admin extends User{

    /**
     * Adds a new student to the current list of students
     * @return boolean result indicating if the operation is a success or failure;
     */
    public static boolean addStudent() {
        // initialise result = false
        boolean result = false;

        // initialise scanner object
        Scanner sc = new Scanner(System.in);

        // get input from the user
        // Input could be a method from main UI?
        System.out.print("Enter the new student's name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter the new student's matriculation number: ");
        String matriculationNumber = sc.nextLine();

        System.out.print("Enter the new student's nationality: ");
        String nationality = sc.nextLine();

        System.out.print("Enter the new student's major: ");
        String major = sc.nextLine();

        System.out.print("Enter the new student's loginID: ");
        String loginId = sc.nextLine();

        System.out.print("Enter the new student's loginPW: ");
        String loginPW = sc.nextLine();

        System.out.print("Enter the new student's gender(M/F): ");
        char gender = sc.next().charAt(0);

        System.out.print("Enter the new student's year of study: ");
        int yearOfStudy = sc.nextInt();

        // To be added into the student constructor
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm:ss", Locale.ENGLISH);
//
//        System.out.print(" Enter the new student's access start time in the following format (dd/MM/yy HH:mm:ss): ");
//
//        System.out.print(" Enter the new student's access end time in the following format (dd/MM/yy HH:mm:ss): ");

        // https://stackoverflow.com/questions/5301226/convert-string-to-calendar-object-in-java

        // insert object into the file - readserialisedobject
        Student newStudent = new Student(studentName, matriculationNumber, nationality, major, gender, yearOfStudy, loginId, loginPW);

        ArrayList<Student> studentList = loadStudentFile(); // load student object to variable

        studentList.add(newStudent);

        try {
            saveStudentFile(studentList);
            result = true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

	    return result;
    }

    /**
     * Adds a new course to the current list of courses
     * @return boolean result indicating if the operation is a success or failure;
     */
    public static boolean addCourse() {
        boolean result = false; // initialise variable

        // initialise scanner object
        Scanner sc = new Scanner(System.in);

        // get input from the user
        // Input could be a method from main UI?
        System.out.print("Enter the new course's name: ");
        String courseName = sc.nextLine();

        System.out.print("Enter the new course's code: ");
        String courseID = sc.nextLine();

        System.out.print("Enter the new course's AU: ");
        int au = sc.nextInt();

        // insert object into the file - readserialisedobject
        Course newCourse = new Course(courseName, courseID, au);

        ArrayList<Course> courseList = loadCoursesFile(); // load course object to variable
        // ArrayList<Course> courseList = (ArrayList)loadCoursesFile();

        courseList.add(newCourse);

        try {
            saveCoursesFile(courseList);
            result = true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        return result; // temp value
    }

    /**
     * Updates an existing course from the current list of courses
     * @return boolean result indicating if the operation is a success or failure;
     */
    public static boolean updateCourse() {
        // initialise boolean result
        boolean result = false;
        Scanner sc = new Scanner(System.in);

        // GET primary key from the user (what they want to update)
        System.out.println("Enter the course ID that you wish to update: ");

        // Retrieve results based on primary key

        // Get updates from the user

        // Update File

        return true; // temp value
    }

    /**
     * Allow admin to display all the students that are enrolled in a specific index number of a course
     * @return the list of student with that specific index number of the course
     */
    public ArrayList<Student> printStudentList() {

        // get Student

        // print Student
        return null;
    }

    /**
     * Allow admin to display all the students that are enrolled in a specific course
     * @param course Input from the main UI which is input by the admin
     * @return the list of student enrolled in a specific course
     */
    public ArrayList<Student> printStudentEnrolled(Course course) {

        ArrayList<Student> studentList = loadStudentFile(); // load student object to variable

        return null;
    }
}
