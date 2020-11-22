package control;

import entity.Course;
import entity.Index;
import entity.Student;

import java.util.ArrayList;

public class AdminManager {

    /* ------ Admin Related Methods: Start ------ */
    /**
     * Adds a new course to the current list of courses
     *
     * @return boolean result indicating if the operation is a success or failure;
     */
    public static boolean addNewCourse(Course newCourse) {
        CourseManager.listOfCourses.add(newCourse);
        CourseManager.saveCoursesFile();
        return true;
    }

    /**
     * To add an index object to the course object based on course ID
     *
     * @param courseID The course's courseID that the index to be added
     * @param index    The index object to be added
     * @return boolean result indicating if the operation is a success or failure
     */
    public static boolean addNewIndex(String courseID, Index index) {
        // initialise
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

        for (int i = 0; i < CourseManager.listOfCourses.size(); i++) {
            if (CourseManager.listOfCourses.get(i).getCourseID().equals(courseID)) {
                ArrayList<Index> indexArrayList = CourseManager.listOfCourses.get(i).getIndex();
                for (int j = 0; j < indexArrayList.size(); j++) {
                    ArrayList<Student> tempStudentArrayList = indexArrayList.get(j).getStudentsEnrolled();
                    studentArrayList.addAll(tempStudentArrayList);
                }
            }
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
        StudentManager.listOfStudents.add(student);
        StudentManager.saveStudentsFile();
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
}
