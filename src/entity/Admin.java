package entity;

// scanner object

public class Admin extends User {

	private String staffID;

	public Admin(String loginID, String loginPW) {
		super(loginID, loginPW);
	}

	public String getStaffID() {
		return staffID;
	}

	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	/*
	 * ---------------------- Old Code Start
	 * -----------------------------------------
	 */

//    /**
//     * Adds a new course to the current list of courses
//     * @return boolean result indicating if the operation is a success or failure;
//     */
//    public static boolean addCourse(Course newCourse) {
//        // Load the course object
//        ArrayList<Course> courseList = loadCoursesFile();
//
//        // attempt to add the new course
//        try {
//            courseList.add(newCourse);
//            saveCoursesFile(courseList);
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
//        ArrayList<Course> courseArrayList = loadCoursesFile(); // load student object to variable
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
//            saveCoursesFile(courseArrayList);
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
//            // retrieve course object
//            ArrayList<Course> courseListUpdate = loadCoursesFile();
//
//            // find course object based on courseID
//            for(int i = 0; i < courseListUpdate.size(); i++){
//                if(courseListUpdate.get(i).getCourseID().equals(updateCourse.getCourseID()))
//                {
//                    courseListUpdate.set(i, updateCourse);
//                    break;
//                }
//            }
//            // save course file
//            try {
//                saveCoursesFile(courseListUpdate);
//                return true;
//            }
//            catch (Exception exception) {
//                exception.printStackTrace();
//            }
//            return false;
//    }
//
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
//        ArrayList<Course> courseArrayList = loadCoursesFile(); // load student object to variable
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
//            System.out.format("| %-21s| %-9s| %-19s|\n",studentArrayList.get(i).getName(),
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
//        ArrayList<Course> courseArrayList = loadCoursesFile();
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
	/*
	 * ---------------------- Old Code End -----------------------------------------
	 */
}
