package boundary;

import control.CourseManager;
import control.StudentManager;
import entity.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static control.fileManager.*;

public class AdminUI {

    static Scanner sc = new Scanner(System.in);

    /* To load Course */
    static CourseManager cmngr = new CourseManager();
    static StudentManager stmngr = new StudentManager();


    public static void main(String[] args) throws NoSuchAlgorithmException {

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
                    addCourseUI(sc);
                    break;
                case 2:
                    System.out.println("2. Add a new index group");
                    addIndexUI(sc, null);
                    break;
                case 3:
                    System.out.println("3. Update existing course");
                    updateCourseUI(sc);
                    break;
                case 4:
                    System.out.println("4. Check vacancy for an existing index group");
                    break;
                case 5:
                    System.out.println("5. Add a new student");
                    addStudentUI(sc);
                    break;
                case 6:
                    System.out.println("6. Edit student access periods");
                    break;
                case 7:
                    System.out.println("7. Print list of students by index group number");
                    printIndexStudentListUI(sc);
                    break;
                case 8:
                    System.out.println("8. Print list of students by course");
                    printCourseStudentListUI(sc);
                    break;
                default:
                    System.out.println("");
                    break;
            }
        } while (choice > 0 && choice < 9);

    }

    /*    Admin UI Course Methods      */
    /**
     * UI to handles the adding of course operation done by admin, adding of index to course will be handled
     * by addIndexUI. IndexList will be null atm
     * @param sc Scanner to read the user (admin) input
     */
    public static void addCourseUI(Scanner sc)
    {
        // Get necessary input from the users: name, id, au and index
        System.out.println("Enter the new course's ID: ");
        String courseID = sc.nextLine();

        System.out.println("Enter the new course's name: ");
        String courseName = sc.nextLine();

        System.out.println("Enter the new course's AU: ");
        int au = sc.nextInt();

        ArrayList<Index> indexArrayList = new ArrayList<Index>();

        // load variable to course object >>> set index to null for now >>> call add index later
        Course newCourse = new Course(courseName, courseID, au, indexArrayList);

        // confirmation
        System.out.println("Press Y to Confirm, Press N to Cancel: ");
        char choice = Character.toUpperCase(sc.next().charAt(0));

        if(choice == 'Y')
        {
            // validation to check if course exists
            if(CourseManager.findCourseObject(courseID).getCourseID() == null)
            {
                // add course
                boolean result = CourseManager.addNewCourse(newCourse);
                if(result == true) {
                    System.out.println("Course record created. Returning to main UI....\n");
                } else {
                    System.out.println("Error creating Course, Please contact IT administrator. Returning to main UI....\n");
                }
            }
            else
            {
                System.out.println("Course exists. Returning to main UI....\n");
            }
        }
        else
        {
            System.out.println("Operation is cancelled. Returning to main UI....\n");
        }
    }

    /**
     * To add a new index object to the course
     * @param sc Scanner to read the user (admin) input
     */
    public static void addIndexUI(Scanner sc, String courseID){
        // Get necessary input from the users: name, id, au and index
        // if courseID is null or else use the pass in value
        if(courseID == null) {
            System.out.println("Enter the course's ID for the Index Group: ");
            courseID = sc.nextLine();
        }

        if(CourseManager.findCourseObject(courseID).getCourseID() != null) {

            System.out.println("Enter the new Index ID: ");
            String indexID = sc.nextLine();

            System.out.println("Enter the total size of the Index Group: ");
            int totalSize = sc.nextInt();

            // call add lesson UI
            ArrayList<Lesson> lessonArrayList = createLessonUI(sc);

            // load variable to index object
            Index newIndex = new Index(indexID, totalSize, lessonArrayList);

            // confirmation
            System.out.println("Press Y to Confirm, Press N to Cancel: ");
            char choice = Character.toUpperCase(sc.next().charAt(0));

            if (choice == 'Y') {
                // validation to check if index exists
                if (/*Course.findIndexObject(indexID).getIndexID() == null*/Index.findIndex(courseID, indexID).getIndexID() == null) {
                    // add course
                    boolean result = CourseManager.addNewIndex(courseID, newIndex);
                    if (result) {
                        System.out.println("Index record created. Returning to main UI....\n");
                    } else {
                        System.out.println("Error creating Index, Please contact IT administrator. Returning to main UI....\n");
                    }
                } else {
                    System.out.println("Index exists. Returning to main UI....\n");
                }
            } else {
                System.out.println("Operation is cancelled. Returning to main UI....\n");
            }
        }
        else{
            System.out.println("Course ID not found. Returning to main UI....\n");
        }
    }

    /**
     * to create a form for user to create an array list of lesson
     * @param sc Scanner to read the user (admin) input
     * @return an array list of lesson that was inputted by the user
     */
    public static ArrayList<Lesson> createLessonUI(Scanner sc)
    {
        // create empty array to store
        ArrayList<Lesson> lessonArrayList = new ArrayList<Lesson>();

        System.out.println("Enter the number of lessons (Lecture+Tutorial+Lab) for the Index Group: ");
        int numberOfLessons = sc.nextInt();

        for(int i = 0; i < numberOfLessons; i++){
            // get lesson type
            System.out.println("\nEnter the lesson's type in term of: \n1. Lecture \n2. Tutorial \n3. Lab: ");
            boolean checkInput = false;
            String strLessonType = null;
            int intLessonType = 0;
            do{
                try{
                    intLessonType = sc.nextInt();
                    sc.nextLine();
                    if(intLessonType > 0 && intLessonType < 4){
                        checkInput = true;
                    }
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Please enter within the correct range!");
                    sc.nextLine();
                }
            } while(!checkInput);
            if (intLessonType == 1) {
                strLessonType = "Lecture";
            } else if (intLessonType == 2) {
                strLessonType = "Tutorial";
            } else if (intLessonType == 3) {
                strLessonType = "Laboratory";
            }

            System.out.println("Enter the lesson's start time in term of HH:MM: ");
            String startTime = sc.nextLine();

            System.out.println("Enter the lesson's end time in term of HH:MM: ");
            String endTime = sc.nextLine();

            // get lesson day
            System.out.println("\nEnter the lesson's day in term of: \n1. Monday \n2. Tuesday \n3. Wednesday:" +
                    "\n4. Thursday \n5. Friday \n6. Saturday ");
            int lessonDay = sc.nextInt();

            Lesson lesson = new Lesson(strLessonType, startTime, endTime, lessonDay);
            lessonArrayList.add(lesson);
        }
        return lessonArrayList;
    }

    /**
     * To update an existing course
     * @param sc Scanner to read the user (admin) input
     */
    public static void updateCourseUI(Scanner sc){
        // initialise
        Course updateCourse = new Course();

        System.out.println("Enter the Course ID that you wish to update: ");
        String courseID = sc.nextLine();

        if(CourseManager.findCourseObject(courseID).getCourseID()!= null) {
            updateCourse = CourseManager.findCourseObject(courseID);
            System.out.println("Course record found! Which of the following do you wish to update?: ");
            System.out.println("1. Course's Name");
            System.out.println("2. Course's AU Credits");
            System.out.println("3. Add new index group");
            System.out.println("4. Remove existing index group");
            System.out.println("5. Remove course");
            System.out.println("6. Go back to main menu");

            int choice = 0;
            do {
                try {
                    choice = sc.nextInt();
                    if (choice > 0 && choice < 7) {
                        sc.nextLine();
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Enter a valid integer!");
                    sc.nextLine();
                }
            } while (true);

            switch (choice){
                case 1:
                    System.out.println("Current Course's name: " + updateCourse.getCourseName());
                    System.out.println("Enter the new Course's name: ");
                    String updateCourseName = sc.nextLine();
                    updateCourse.setCourseName(updateCourseName);
                    boolean result = CourseManager.updateCourse(updateCourse);
                    if(result == true) {
                        System.out.println("Course's name updated. Returning to main UI....\n");
                    } else {
                        System.out.println("Error updating Course's name, Please contact IT administrator. Returning to main UI....\n");
                    }
                    break;
                case 2:
                    System.out.println("Current Course's AU Credits");
                    System.out.println("Enter the new Course's AU Credits");
                    int updateAUCredits = 0;
                    do {
                        try {
                            updateAUCredits = sc.nextInt();
                            if (updateAUCredits>0) {
                                sc.nextLine();
                                break;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Enter a valid integer!");
                            sc.nextLine();
                        }
                    } while (true);
                    updateCourse.setAu(updateAUCredits);
                    boolean result1 = CourseManager.updateCourse(updateCourse);
                    if(result1 == true) {
                        System.out.println("Course's AU updated. Returning to main UI....\n");
                    } else {
                        System.out.println("Error updating Course's AU, Please contact IT administrator. Returning to main UI....\n");
                    }
                case 3:
                    addIndexUI(sc, courseID);
                case 4:
                    ArrayList<Index> updateCourseIndex = updateCourse.getIndex();
                    for(int i = 0; i < updateCourseIndex.size(); i++){
                        System.out.println(updateCourseIndex.get(i).getIndexID());
                    }
                    System.out.println("Enter the index group to remove from course: ");
                    String removeIndexID = sc.nextLine();
                    if(Index.findIndex(courseID, removeIndexID).getIndexID() != null){
                        boolean result3 = Index.removeIndex(courseID, removeIndexID);
                        if(result3 == true) {
                            System.out.println("Remove index successfully. Returning to main UI....\n");
                        } else {
                            System.out.println("Error removing index, Please contact IT administrator. Returning to main UI....\n");
                        }
                    }
                    else{
                        System.out.println("Invalid index ID, Returning to main menu");
                    }
                    break;
                case 5:
                    System.out.println("Press Y to Confirm delete, Press N to Cancel: ");
                    char confirm = Character.toUpperCase(sc.next().charAt(0));

                    if(confirm == 'Y')
                    {
                        boolean result4 = Course.removeCourse(updateCourse.getCourseID());
                        if(result4 == true) {
                            System.out.println("Remove Course Successfully.  Returning to main UI....\n");
                        } else {
                            System.out.println("Error removing Course, Please contact IT administrator. Returning to main UI....\n");
                        }

                    }
                    else
                    {
                        System.out.println("Operation is cancelled. Returning to main UI....\n");
                    }
                    break;
                default:
                    System.out.println("Returning to main UI....\n");
                    break;
            }
        }
        else{
            System.out.println("CourseID do not exists. Returning to main UI....\n");
        }
    }

    /**
     * To create a form for user to add an student
     * @param sc Scanner to read the user (admin) input
     * @throws NoSuchAlgorithmException This exception is thrown when a particular cryptographic algorithm is
     * requested but is not available in the environment.
     */
    public static void addStudentUI(Scanner sc) throws NoSuchAlgorithmException {

        // get input from the user
        System.out.print("Enter the new student's name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter the new student's matriculation number: ");
        String matriculationNumber = sc.nextLine();

        System.out.print("Enter the new student's nationality: ");
        String nationality = sc.nextLine();

        System.out.print("Enter the new student's major: ");
        String major = sc.nextLine();

        System.out.print("Enter the new student's gender(M/F): ");
        char gender = sc.next().charAt(0);

        System.out.print("Enter the new student's year of study: ");
        int yearOfStudy = sc.nextInt();

        System.out.print("Enter the new student's loginID: ");
        String loginId = sc.nextLine();

        System.out.print("Enter the new student's loginPW: ");
        String loginPW = sc.nextLine();
        loginPW = User.hashString(loginPW);

        // insert object into the file
        Student newStudent = new Student(studentName, matriculationNumber, nationality, major, gender, yearOfStudy, loginId, loginPW);

        // confirmation
        System.out.println("Press Y to Confirm, Press N to Cancel: ");
        char choice = Character.toUpperCase(sc.next().charAt(0));

        if(choice == 'Y')
        {
            // validation to check if index exists
            if(Student.findStudent(matriculationNumber).getMatricNumber() == null)
            {
                // add student
                boolean result = addStudent(newStudent);
                if(result == true) {
                    System.out.println("Student record created. Returning to main UI....\n");
                } else {
                    System.out.println("Error creating Student, Please contact IT administrator. Returning to main UI....\n");
                }
            }
            else
            {
                System.out.println("Student exists. Returning to main UI....\n");
            }
        }
        else
        {
            System.out.println("Operation is cancelled. Returning to main UI....\n");
        }
    }

    /**
     * To create a form to get what index ID (and courseID) that the user(admin) want to print
     * @param sc Scanner to read the user (admin) input
     */
    public static void printIndexStudentListUI(Scanner sc){
        System.out.print("Enter the index's Course ID: ");
        String courseID = sc.nextLine();

        System.out.print("Enter the index ID: ");
        String indexID = sc.nextLine();

        if(CourseManager.findCourseObject(courseID).getCourseID() != null && Index.findIndex(courseID, indexID).getIndexID() != null){
            CourseManager.printIndexStudentList(courseID, indexID);
        }
        System.out.println("Returning to main UI....\n");
    }
    /**
     * To create a form to get what course ID that the user(admin) want to print
     * @param sc Scanner to read the user (admin) input
     */
    public static void printCourseStudentListUI(Scanner sc){
        System.out.print("Enter the index's Course ID: ");
        String courseID = sc.nextLine();

        if(CourseManager.findCourseObject(courseID).getCourseID() != null){
            CourseManager.printCourseStudentList(courseID);
        }
        System.out.println("Returning to main UI....\n");
    }
    /*   End of Admin UI Course Methods      */

    /*   Start of Admin Logic Course Methods      */
    /**
     * Adds a new course to the current list of courses
     * @return boolean result indicating if the operation is a success or failure;
     */
//    public static boolean addCourse(Course newCourse) {
//        // Load the course object
//        //ArrayList<Course> courseList = loadCoursesFile();
//        ArrayList<Course> courseList = CourseManager.getListOfCourses();
//
//        // attempt to add the new course
//        try {
//            courseList.add(newCourse);
//            //saveCoursesFile(courseList);
//            CourseManager.setListOfCourses(courseList);
//            cmngr.saveCoursesFile();
//            return true;
//        }
//        catch (Exception exception) {
//            exception.printStackTrace();
//            return false;
//        }
//    }
//    /**
//     * To add an index object to the course object based on course ID
//     * @param courseID The course's courseID that the index to be added
//     * @param index The index object to be added
//     * @return boolean result indicating if the operation is a success or failure
//     */
//    public static boolean addIndex(String courseID, Index index)
//    {
//        // initialise
//        ArrayList<Index> indexArrayList = new ArrayList<Index>();
//
//        // load course file
//        //ArrayList<Course> courseArrayList = loadCoursesFile(); // load student object to variable
//        ArrayList<Course> courseArrayList = CourseManager.getListOfCourses();
//
//        for(int i = 0; i < courseArrayList.size(); i++)
//        {
//            if(courseArrayList.get(i).getCourseID().equals(courseID))
//            {
//                courseArrayList.get(i).getIndex().add(index);
//                /* Solution 2 */
//                //indexArrayList = courseArrayList.get(i).getIndex();
//                //indexArrayList.add(index);
//                //courseArrayList.get(i).setIndex(indexArrayList);
//            }
//        }
//        // save the index
//        try {
//            //saveCoursesFile(courseArrayList);
//            CourseManager.setListOfCourses(courseArrayList);
//            cmngr.saveCoursesFile();
//            return true;
//        }
//        catch (Exception exception) {
//            exception.printStackTrace();
//            return false;
//        }
//    }
//    /**
//     * Updates an existing course from the current list of courses
//     * @return boolean result indicating if the operation is a success or failure;
//     */
//    public static boolean updateCourse(Course updateCourse) {
//        // retrieve course object
//        //ArrayList<Course> courseListUpdate = loadCoursesFile();
//        ArrayList<Course> courseListUpdate = CourseManager.getListOfCourses();
//
//        // find course object based on courseID
//        for(int i = 0; i < courseListUpdate.size(); i++){
//            if(courseListUpdate.get(i).getCourseID().equals(updateCourse.getCourseID()))
//            {
//                courseListUpdate.set(i, updateCourse);
//                break;
//            }
//        }
//        // save course file
//        try {
//            //saveCoursesFile(courseListUpdate);
//            CourseManager.setListOfCourses(courseListUpdate);
//            cmngr.saveCoursesFile();
//            return true;
//        }
//        catch (Exception exception) {
//            exception.printStackTrace();
//        }
//        return false;
//    }

//    /**
//     * Adds a new student to the current list of students
//     * @return boolean result indicating if the operation is a success or failure;
//     */
//    public static boolean addStudent(Student student) {
//        ArrayList<Student> studentList = loadStudentFile(); // load student object to variable
//
//        studentList.add(student);
//
//        try {
//            saveStudentFile(studentList);
//            return true;
//        }
//        catch (Exception exception) {
//            exception.printStackTrace();
//            return false;
//        }
//    }
//    /**
//     * Allow admin to display all the students that are enrolled in a specific index number of a course
//     * @param courseID courseID of the index's parent course
//     * @param indexID indexID of the index to be printed
//     * @return boolean result indicating if the operation is a success or failure;
//     */
//    public static boolean printIndexStudentList(String courseID, String indexID ) {
//        //ArrayList<Course> courseArrayList = loadCoursesFile(); // load student object to variable
//        ArrayList<Course> courseArrayList = CourseManager.getListOfCourses();
//
//        ArrayList<Student> studentArrayList = new ArrayList<Student>();
//
//        for(int i = 0; i < courseArrayList.size(); i++){
//            if(courseArrayList.get(i).getCourseID().equals(courseID)){
//                ArrayList<Index> indexArrayList = courseArrayList.get(i).getIndex();
//                for(int j = 0; j < indexArrayList.size(); j++){
//                    if(indexArrayList.get(j).getIndexID().equals(indexID)){
//                        studentArrayList = indexArrayList.get(j).getStudentsEnrolled();
//                    }
//                }
//            }
//        }
//
//        System.out.println("List of students in the Course " + courseID + " of Index Group " + indexID + ":");
//        System.out.println("--------------------------------------------------------");
//        System.out.println("|         Name         |  Gender  |     Nationality    |");
//        System.out.println("--------------------------------------------------------");
//
//        for(int i = 0; i < studentArrayList.size(); i++){
//            System.out.format("| %-25s| %-11s| %-25s|\n",studentArrayList.get(i).getName(),
//                    studentArrayList.get(i).getGender(),studentArrayList.get(i).getNationality());
//        }
//        return true;
//    }
//    /**
//     * Allow admin to display all the students that are enrolled in a specific course
//     * @param courseID courseID of the course to be printed
//     * @return boolean result indicating if the operation is a success or failure;
//     */
//    public static boolean printCourseStudentList(String courseID) {
//        //ArrayList<Course> courseArrayList = loadCoursesFile();
//        ArrayList<Course> courseArrayList = CourseManager.getListOfCourses();
//
//        ArrayList<Student> studentArrayList = new ArrayList<Student>();
//
//        for(int i = 0; i < courseArrayList.size(); i++) {
//            if (courseArrayList.get(i).getCourseID().equals(courseID)) {
//                ArrayList<Index> indexArrayList = courseArrayList.get(i).getIndex();
//                for (int j = 0; j < indexArrayList.size(); j++) {
//                    ArrayList<Student> tempStudentArrayList = indexArrayList.get(j).getStudentsEnrolled();
//                    studentArrayList.addAll(tempStudentArrayList);
//                }
//            }
//        }
//
//        System.out.println("List of students in the Course " + courseID +  ":");
//        System.out.println("--------------------------------------------------------");
//        System.out.println("|         Name         |  Gender  |     Nationality    |");
//        System.out.println("--------------------------------------------------------");
//
//        for(int i = 0; i < studentArrayList.size(); i++){
//            System.out.format("| %-21s| %-9s| %-19s|\n",studentArrayList.get(i).getName(),
//                    studentArrayList.get(i).getGender(),studentArrayList.get(i).getNationality());
//        }
//        return true;
//    }

    /*   End of Admin Logic Course Methods   */

}
