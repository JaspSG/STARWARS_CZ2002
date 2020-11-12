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

    /**
     * To add an index object to the course object based on course ID
     * @param courseID The course's courseID that the index to be added
     * @param index The index object to be added
     * @return boolean result indicating if the operation is a success or failure
     */
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
     * Updates an existing course from the current list of courses
     * @return boolean result indicating if the operation is a success or failure;
     */
    public static boolean updateCourse(Course updateCourse) {
            // retrieve course object
            ArrayList<Course> courseListUpdate = loadCoursesFile();

            // find course object based on courseID
            for(int i = 0; i < courseListUpdate.size(); i++){
                if(courseListUpdate.get(i).getCourseID().equals(updateCourse.getCourseID()))
                {
                    courseListUpdate.set(i, updateCourse);
                    break;
                }
            }
            // save course file
            try {
                saveCoursesFile(courseListUpdate);
                return true;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            return false;
    }

    /**
     * Adds a new student to the current list of students
     * @return boolean result indicating if the operation is a success or failure;
     */
    public static boolean addStudent(Student student) {
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
     * Allow admin to display all the students that are enrolled in a specific index number of a course
     * @return the list of student with that specific index number of the course
     */
    public boolean printCourseStudentList(String courseID, String indexID ) {

        return true;
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
