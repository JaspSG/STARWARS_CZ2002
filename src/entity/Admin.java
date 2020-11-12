package entity;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
// scanner object
import static control.fileManager.*;




public class Admin extends User{
    /**
     * Adds a new course to the current list of courses
     * @return boolean result indicating if the operation is a success or failure;
     */
    public static boolean addCourse(Course newCourse) {
        // Load the course object
        ArrayList<Course> courseList = loadCoursesFile();

        // attempt to add the new course
        try {
            courseList.add(newCourse);
            saveCoursesFile(courseList);
            return true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public static boolean addIndex(String courseID, Index index)
    {
        // initialise
        ArrayList<Index> indexArrayList = new ArrayList<Index>();

        // load course file
        ArrayList<Course> courseArrayList = loadCoursesFile(); // load student object to variable
        for(int i = 0; i < courseArrayList.size(); i++)
        {
            if(courseArrayList.get(i).getCourseID().equals(courseID))
            {
                courseArrayList.get(i).getIndex().add(index);
                /* Solution 2 */
                //indexArrayList = courseArrayList.get(i).getIndex();
                //indexArrayList.add(index);
                //courseArrayList.get(i).setIndex(indexArrayList);
            }
        }

        // save the index
        try {
            saveCoursesFile(courseArrayList);
            return true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    /**
     * Adds a new student to the current list of students
     * @return boolean result indicating if the operation is a success or failure;
     */
    public static boolean addStudent(Student student) {

        // To be added into the student constructor
//        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm:ss", Locale.ENGLISH);
//
//        System.out.print(" Enter the new student's access start time in the following format (dd/MM/yy HH:mm:ss): ");
//
//        System.out.print(" Enter the new student's access end time in the following format (dd/MM/yy HH:mm:ss): ");

        // https://stackoverflow.com/questions/5301226/convert-string-to-calendar-object-in-java

        ArrayList<Student> studentList = loadStudentFile(); // load student object to variable

        studentList.add(student);

        try {
            saveStudentFile(studentList);
            return true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
    /**
     * Updates an existing course from the current list of courses
     * @return boolean result indicating if the operation is a success or failure;
     */
    public static boolean updateCourse() {
        // initialise
        Scanner sc = new Scanner(System.in);
        Course updateCourse = new Course(); // empty course

        // GET primary key from the user (what they want to update)
        System.out.println("Enter the course ID that you wish to update: ");
        String givenCourseID = sc.nextLine();

        // retrieve course object
        ArrayList<Course> courseList = loadCoursesFile();

        // find course object based on courseID
        for(int i = 0; i < courseList.size(); i++){
            if(courseList.get(i).getCourseID().equals(givenCourseID))
            {
                updateCourse = courseList.get(i);
                break;
            }
        }
        int choice = 0;
        boolean validChoice = false;
        if(updateCourse != null) {
            // do stuff here
            System.out.println("Valid Course ID. Enter the options that you wish to update?: ");
            System.out.println("1. Name of the Course");
            System.out.println("2. AU of the course");

            do{
                try{
                    choice = sc.nextInt();
                    if(choice > 0) {
                        validChoice = true;
                        sc.nextLine();
                    }
                } catch (InputMismatchException exception){
                    System.out.println("Enter within valid range!");
                    sc.nextLine();
                }
            } while(validChoice != false);

            validChoice = false;

            switch (choice) {
                case 1:
                    System.out.println("Current Course's name: " + updateCourse.getCourseName());
                    System.out.println("Enter the updated Course's name: ");
                    String updateCourseName = sc.nextLine();
                    updateCourse.setCourseName(updateCourseName);

                case 2:
                    System.out.println("Current Course's AU: " + updateCourse.getCourseName());
                    System.out.println("Enter the updated Course's AU: ");
                    int updateCourseAU = sc.nextInt();
                    updateCourse.setAu(updateCourseAU);

                default:
                    break;
            }

            // retrieve course object
            ArrayList<Course> courseListUpdate = loadCoursesFile();

            // find course object based on courseID
            for(int i = 0; i < courseList.size(); i++){
                if(courseListUpdate.get(i).getCourseID().equals(givenCourseID))
                {
                    courseListUpdate.set(i, updateCourse);
                    break;
                }
            }
            // save course file
            try {
                saveCoursesFile(courseListUpdate);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }

            return true; // temp value

        }
        else{
            System.out.println("Invalid courseID!");
            return false;
        }

    }

    /**
     * Allow admin to display all the students that are enrolled in a specific index number of a course
     * @return the list of student with that specific index number of the course
     */
    public ArrayList<Student> printStudentList() {
        // initialise variable
        Scanner scanner = new Scanner(System.in);
        String indexNumber = null;

        // get input from the user
        System.out.println("Enter the index number that you want to print: ");
        indexNumber = scanner.nextLine();

        // retrieve index object
        //ArrayList<Index> indexList = loadIndexesFile();

        // print Student
        //for(int i = 0; i < indexList.size(); i++) {
//            Index index1 = indexList.get(i);
//            if(index1.getIndexID().contains(indexNumber)){
//                return index1.getStudentsEnrolled();
//            }
//        }
        return null; // if none return
    }

    /**
     * Allow admin to display all the students that are enrolled in a specific course
     * @param course Input from the main UI which is input by the admin
     * @return the list of student enrolled in a specific course
     */
    public ArrayList<Student> printStudentEnrolled(Course course) {

        // initialise variable
        Scanner scanner = new Scanner(System.in);
        String courseCode;

        // get input from the user
        System.out.println("Enter the Course Code that you want to print: ");
        courseCode = scanner.nextLine();

        // retrieve Course object
        ArrayList<Course> courseList = loadCoursesFile();

        // print Student
        ArrayList<Student> testlist;
        for(int i = 0; i < courseList.size(); i++) {
            Course course1 = courseList.get(i);
            if(course1.getCourseID().contains(courseCode)){
                testlist =  course1.getStudentsEnrolled();

                for(int j =0; j < testlist.size();j++)
                {
                    System.out.println(testlist.get(i).getName() + "\n");


                }
                break;
            }
        }
        return null; // if none return
    }
}
