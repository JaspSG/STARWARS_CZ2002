package control;

import entity.Course;
import entity.Index;
import entity.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class AdminManager {

    /* ------ Admin Related Methods: Start ------ */
    /**
     * Adds a new course to the current list of courses
     *
     * @return boolean result indicating if the operation is a success or failure;
     */
    public static boolean addNewCourse(Course newCourse) {
        if (CourseManager.findCourseObject(newCourse.getCourseID()).getCourseID() != null){
            System.out.println("Course exists. Returning to main UI....\n");
            return false;
        }

        CourseManager.listOfCourses.add(newCourse);
        CourseManager.saveCoursesFile();

        System.out.println("Course record created. Returning to main UI....\n");
        return true;
    }

    public static void printListOfCourses(){
        // Print Courses //
        System.out.println("-------------------------------------------------------------");
        System.out.format("| %-15s| %-40s|\n","Course ID","Course Name");
        System.out.println("-------------------------------------------------------------");
        for(int i = 0; i < CourseManager.listOfCourses.size(); i++){
            System.out.format("| %-15s| %-40s|\n",CourseManager.listOfCourses.get(i).getCourseID(),CourseManager.listOfCourses.get(i).getCourseName());
        }
        // end print courses //
    }

    public static void printListOfStudents(){
        // Print Courses //
        System.out.println("-------------------------------------------------------------");
        System.out.format("| %-48s| %-15s|\n","Student Name","Student Matriculation Number");
        System.out.println("-------------------------------------------------------------");
        for(int i = 0; i < CourseManager.listOfCourses.size(); i++){
            System.out.format("| %-48s| %-15s|\n",CourseManager.listOfCourses.get(i).getCourseID(),CourseManager.listOfCourses.get(i).getCourseName());
        }
        // end print courses //
    }

    /**
     * To add an index object to the course object based on course ID
     *
     * @param courseID The course's courseID that the index to be added
     * @param index    The index object to be added
     * @return boolean result indicating if the operation is a success or failure
     */
    public static boolean addNewIndex(String courseID, Index index) {
        // check condition
        if(CourseManager.findCourseObject(courseID).getCourseID() == null){
            System.out.println("Course ID not found. Returning to main UI....\n");
            return false;
        }
        if (CourseManager.findIndex(courseID, index.getIndexID()).getIndexID() != null){
            System.out.println("Index exists. Returning to main UI....\n");
            return false;
        }

        ArrayList<Index> indexArrayList = new ArrayList<Index>();

        for (int i = 0; i < CourseManager.listOfCourses.size(); i++) {
            if (CourseManager.listOfCourses.get(i).getCourseID().equals(courseID)) {
                CourseManager.listOfCourses.get(i).getIndex().add(index);
            }
        }
        CourseManager.saveCoursesFile();
        return true;
    }

    /**
     * Updates an existing course from the current list of courses
     *
     * @return boolean result indicating if the operation is a success or failure;
     */
    public static boolean updateCourse(Course updateCourse) {
        for (int i = 0; i < CourseManager.listOfCourses.size(); i++) {
            if (CourseManager.listOfCourses.get(i).getCourseID().equals(updateCourse.getCourseID())) {
                CourseManager.listOfCourses.set(i, updateCourse);
                break;
            }
        }
        CourseManager.saveCoursesFile();
        return true;
    }

    /**
     * Updates an existing index information from the current list of courses
     *
     * @param index    The updated index object
     * @param indexID  The original indexID
     * @param courseID The original course ID
     * @return boolean result indicating if the operation is a success or failure;
     */
    public static boolean updateIndex(Index index, String indexID, String courseID) {
        for (int i = 0; i < CourseManager.listOfCourses.size(); i++) {
            if (CourseManager.listOfCourses.get(i).getCourseID().equals(courseID)) {
                ArrayList<Index> indexArrayList = CourseManager.listOfCourses.get(i).getIndex();
                for (int j = 0; j < indexArrayList.size(); j++) {
                    if (indexArrayList.get(j).getIndexID().equals(indexID)) {
                        CourseManager.listOfCourses.get(i).getIndex().set(j, index);
                    }
                }
            }
        }
        CourseManager.saveCoursesFile();
        return true;
    }

    /**
     * Allow admin to display all the students that are enrolled in a specific index
     * number of a course
     *
     * @param courseID courseID of the index's parent course
     * @param indexID  indexID of the index to be printed
     * @return boolean result indicating if the operation is a success or failure;
     */
    public static boolean printIndexStudentList(String courseID, String indexID) {
        // initialise
        if (CourseManager.findCourseObject(courseID).getCourseID() == null
                && CourseManager.findIndex(courseID, indexID).getIndexID() == null) {
            System.out.println("Returning to main UI....\n");
            return false;
        }

        ArrayList<Student> studentArrayList = new ArrayList<Student>();

        for (int i = 0; i < CourseManager.listOfCourses.size(); i++) {
            if (CourseManager.listOfCourses.get(i).getCourseID().equals(courseID)) {
                ArrayList<Index> indexArrayList = CourseManager.listOfCourses.get(i).getIndex();
                for (int j = 0; j < indexArrayList.size(); j++) {
                    if (indexArrayList.get(j).getIndexID().equals(indexID)) {
                        studentArrayList = indexArrayList.get(j).getStudentsEnrolled();
                    }
                }
            }
        }
        if(studentArrayList.size() > 0){
            System.out.println("List of students in the Course " + courseID + " of Index Group " + indexID + ":");
            System.out.println("-----------------------------------------------------------------");
            System.out.format("| %-25s| %-8s| %-25s|\n","Name", "Gender", "Nationality");
            System.out.println("-----------------------------------------------------------------");

            for (int i = 0; i < studentArrayList.size(); i++) {
                System.out.format("| %-25s| %-8s| %-25s|\n", studentArrayList.get(i).getName(),
                        studentArrayList.get(i).getGender(), studentArrayList.get(i).getNationality());
            }
        }
        else{
            System.out.println("There is currently 0 number of student enrolled in " + courseID + " of Index Group " + indexID + " .");
            return false;
        }

        return true;
    }

    /**
     * Allow admin to display all the students that are enrolled in a specific
     * course
     *
     * @param courseID courseID of the course to be printed
     * @return boolean result indicating if the operation is a success or failure;
     */
    public static boolean printCourseStudentList(String courseID) {
        // initialise

        if (CourseManager.findCourseObject(courseID).getCourseID() == null) {
            System.out.println("Returning to main UI....\n");
            return false;
        }
        ArrayList<Student> studentArrayList = new ArrayList<Student>();
        ArrayList<Index> indexArrayList = new ArrayList<Index>();
        for (int i = 0; i < CourseManager.listOfCourses.size(); i++) {
            if (CourseManager.listOfCourses.get(i).getCourseID().equals(courseID)) {
                indexArrayList = CourseManager.listOfCourses.get(i).getIndex();
                break;
            }
        }
        for (int j = 0; j < indexArrayList.size(); j++) {
            ArrayList<Student> tempStudentArrayList = indexArrayList.get(j).getStudentsEnrolled();
            studentArrayList.addAll(tempStudentArrayList);
        }
        if(studentArrayList.size() > 0){
            System.out.println("List of students in the Course " + courseID + ":");
            System.out.println("-----------------------------------------------------------------");
            System.out.format("| %-25s| %-8s| %-25s|\n","Name", "Gender", "Nationality");
            System.out.println("-----------------------------------------------------------------");

            for (int i = 0; i < studentArrayList.size(); i++) {
                System.out.format("| %-25s| %-8s| %-25s|\n", studentArrayList.get(i).getName(),
                        studentArrayList.get(i).getGender(), studentArrayList.get(i).getNationality());
            }
        }
        else{
            System.out.println("There is currently 0 number of student enrolled in " + courseID + " .");
            return false;
        }
        return true;
    }
    /* ------ Admin Related Methods: End ------ */
    /* ------ Admin Related Methods: Start ------ */
    /**
     * Adds a new student to the current list of students
     *
     * @return boolean result indicating if the operation is a success or failure;
     */
    public static boolean addNewStudent(Student student) {
        if(StudentManager.findStudentObject(student.getMatricNumber()).getMatricNumber() != null){
            System.out.println("Student exists. Returning to main UI....\n");
            return false;
        }


        StudentManager.listOfStudents.add(student);
        StudentManager.saveStudentsFile();
        System.out.println("Student record created. Returning to main UI....\n");
        return true;
    }

    /**
     * Updates an existing student from the current list of student
     *
     * @return boolean result indicating if the operation is a success or failure;
     */
    public static boolean updateStudent(Student updateStudent) {
        for (int i = 0; i < StudentManager.listOfStudents.size(); i++) {
            if (StudentManager.listOfStudents.get(i).getMatricNumber().equals(updateStudent.getMatricNumber())) {
                StudentManager.listOfStudents.set(i, updateStudent);
                break;
            }
        }
        StudentManager.saveStudentsFile();
        return true;
    }

    /* ------ Admin Related Methods: End ------ */
    /* ------ Admin Update Access Period  Start ------ */
    public static boolean updateAccessPeriod(String matriculationNumber, String startTime, String endTime){
        if (StudentManager.findStudentObject(matriculationNumber).getMatricNumber() == null){
            System.out.println("Invalid matriculation number. Returning to main UI ...");
            return false;
        }
        // initialisation
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();

        // logic
        Student updateStudent = StudentManager.findStudentObject(matriculationNumber);

        try {
            startCalendar.setTime(simpleDateFormat.parse(startTime));
            endCalendar.setTime(simpleDateFormat.parse(endTime));
            // set access period
            updateStudent.setStartTime(startCalendar);
            updateStudent.setEndTime(endCalendar);
            // seek user confirmation
            // update course
            AdminManager.updateStudent(updateStudent);
            System.out.println("Student Access Period Updated. Returning to main menu ...");
            return true;

        } catch (ParseException parseException) {
            System.out.println("Invalid date format. Returning to main menu...");
            return false;
        }
    }
    public static boolean checkVacancy(String courseID, String indexID){
        Index index = CourseManager.findIndex(courseID, indexID);

        if (index.getIndexID() != null) {

            int result = CourseManager.checkVacancy(courseID, indexID);

            if (result != -1) {
                System.out.println("The number of available slot for " + indexID + " is " + result + "/" + index.getIndexID() + " .");
            } else {
                System.out.println("There is no vacancy for " + indexID + " .");
            }
            return true;
        } else {
            System.out.println("Invalid index ID or Course ID. Returning to main menu ...");
            return false;
        }
    }
    /* ------ Admin Update Access Period  End   ------ */
}
