package control;

import entity.Course;
import entity.Index;
import entity.Lesson;
import entity.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {

	Student currentStudent = new Student();
	CourseManager cmngr = new CourseManager();
	int studentIndex;
	static ArrayList<Student> listOfStudents = new ArrayList<Student>();

	public StudentManager() {
		listOfStudents = fileManager.loadStudentFile();

	}

	public StudentManager(String loginID) {
		listOfStudents = fileManager.loadStudentFile();
		studentIndex = 0;
		for (Student student : listOfStudents) {
			if (student.getLoginID().equals(loginID)) {
				this.currentStudent = student;
				studentIndex = listOfStudents.indexOf(currentStudent);
			}
		}
		//System.out.println("The index is : "+studentIndex);

	}

	public StudentManager(int index) {
		listOfStudents = fileManager.loadStudentFile();
		studentIndex = index;
		currentStudent = listOfStudents.get(studentIndex);

	}
	
	public Student findCurrentStudent()
	{
		return this.currentStudent;
	}

	public static Student findStudentObject(String matriculationNumber) {
		for (Student student : listOfStudents) {
			if (student.getMatricNumber().equals(matriculationNumber)) {
				return student;
			}
		}
		System.out.println("Student not found");
		Student emptyStudent = new Student();
		return emptyStudent; // NOTE: STRING DEFAULTS ARE NULL, HENCE TO CHECK IF OBJECT IS EMPTY, CHECK IF A
		// STRING ATTRIBUTE IS NULL
	}

	public static void saveStudentsFile() {
		try {
			fileManager.saveStudentFile(listOfStudents);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Student> getListOfStudents() {
		return listOfStudents;
	}

	public static void setListOfStudents(ArrayList<Student> listOfStudents) {
		StudentManager.listOfStudents = listOfStudents;
	}

//	int currentStudentIndex;
//
//	public StudentManager(int global_i) {
//		currentStudentIndex = global_i;
//		listOfStudents = fileManager.loadStudentFile();
//	} // to remove

	public boolean addCourse(String course, String indexID) {

		System.out.println("Adding Course ID : " + course + " and Index ID : " + indexID);
		// Searching if course exists
		Course newcourse = CourseManager.findCourseObject(course);
		if (newcourse.getCourseID() != null) {
			System.out.println("Course Exists");
			// Add in a check for wait list
			ArrayList<Course> enrolledCourses = currentStudent.getCourseEnrolled();
			if (enrolledCourses != null) {
				for (Course enrolledCourse : enrolledCourses) {
					if (enrolledCourse.getCourseID().equals(course)) {
						System.out.println("Already enrolled in this course!");
						return false;
					}

				}
				System.out.println("Adding student to course!");
				if(!cmngr.addStudentToCourse(currentStudent, course, indexID)) {
					System.out.println("Failed to add student to course!");
					return false;
				}
				Index newindex = newcourse.findIndexObject(indexID);
				ArrayList<Index> indexlist = new ArrayList<Index>();
				indexlist.add(newindex);
				newcourse.setIndex(indexlist);
				enrolledCourses.add(newcourse);
				listOfStudents.get(studentIndex).setCourseEnrolled(enrolledCourses);
				try {
					MailManager.sendMail(currentStudent.getEmail());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				saveStudentsFile();
				for(Course course2 : listOfStudents.get(studentIndex).getCourseEnrolled()) {
					for (Index index2 : course2.getIndex() ) {
						System.out.println("Index ID of "+ course2.getCourseID() +  " is " + index2.getIndexID());
					}
				}
				System.out.println("Successful!");
				return true;
			}
			// If no enrolled courses :
			else {
				// Add student to Course Object
				System.out.println("Adding student to course!");
				
				if(!cmngr.addStudentToCourse(currentStudent, course, indexID)) {
					System.out.println("Failed to add student to course!");
					return false;
				}
				// Add Course to Student Object
				enrolledCourses = new ArrayList<Course>();
				Index newindex = newcourse.findIndexObject(indexID);
				ArrayList<Index> indexlist = new ArrayList<Index>();
				indexlist.add(newindex);
				newcourse.setIndex(indexlist);
				enrolledCourses.add(newcourse);
				listOfStudents.get(studentIndex).setCourseEnrolled(enrolledCourses);
				try {
					MailManager.sendMail(currentStudent.getEmail());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Save students
				saveStudentsFile();
				for(Course course2 : listOfStudents.get(studentIndex).getCourseEnrolled()) {
					for (Index index2 : course2.getIndex() ) {
						System.out.println("Index ID of "+ course2.getCourseID() +  " is " + index2.getIndexID());
					}
				}
				System.out.println("Successful!");
				return true;

			}

		}
		System.out.println("Course does not exist!");
		return false; // temporary value
	}
//		ArrayList<Course> listOfCourses = new ArrayList<Course>();
//		listOfCourses = fileManager.loadCoursesFile();
//		System.out.println("AddingCourse : " + course + "Group: " + tutGroup);
//		ArrayList<Course> tempCurrentCourses = new ArrayList<Course>();
//		tempCurrentCourses = listOfStudents.get(currentStudentIndex).getCourseEnrolled();
//		for (Course Courses : listOfCourses) {
//			// System.out.println(Courses.getCourseID());
//			if (Courses.getCourseID().equals(course)) {
//				// System.out.println("Course exists!");
//				if (tempCurrentCourses != null) {
//					for (Course CheckCurrentCourse : tempCurrentCourses) {
//						if (CheckCurrentCourse.getCourseID().equals(course)) {
//							System.out.println("Already enrolled in course!");
//							return false;
//						} else {
//							cmngr.addStudent(listOfStudents.get(currentStudentIndex), course, tutGroup);
//							tempCurrentCourses.add(Courses);
//							listOfStudents.get(currentStudentIndex).setCourseEnrolled(tempCurrentCourses);
//							System.out.println("Adding Student to Course!");
//							try {
//								fileManager.saveStudentFile(listOfStudents);
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//							return true;
//						}
//					}
//				} else {
//					cmngr.addStudent(listOfStudents.get(currentStudentIndex), course, tutGroup);
//					tempCurrentCourses = new ArrayList<Course>();
//					tempCurrentCourses.add(Courses);
//					listOfStudents.get(currentStudentIndex).setCourseEnrolled(tempCurrentCourses);
//					System.out.println("Added!");
//					try {
//						fileManager.saveStudentFile(listOfStudents);
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//					return true;
//				}
//			}
//		}
//		System.out.println("Course does not exist!");

	public boolean dropCourse(String course) {

		ArrayList<Course> coursesEnrolled = currentStudent.getCourseEnrolled();
		if (coursesEnrolled != null) {
			Course courseobject = CourseManager.findCourseObject(course);
			if (courseobject != null) {
				System.out.println("Course ID of dropped course is : " + courseobject.getCourseID());
				for (Course courses : coursesEnrolled) {
					if (courses.getCourseID() == courseobject.getCourseID()) {
						// Drop the class and remove student
						System.out.println("Dropping Course!");
						cmngr.removeStudentFromCourse(currentStudent, course);
						coursesEnrolled.remove(courseobject);
						listOfStudents.get(studentIndex).setCourseEnrolled(coursesEnrolled);
						saveStudentsFile();
						return true;
					}
				}
				System.out.println("You do not have this course!");
				return false;

			} else {
				System.out.println("Invalid course!");
				return false;
			}
		}
		System.out.println("No courses available to drop!");
		return false; // temporary value
	}

	public void printCourseRegistered() {
		// HELLO
		if (currentStudent.getCourseEnrolled() != null) {
			System.out.println("----------------------------------------------------");
			System.out.println("|  Course ID |  Course Name    | Index:             |");
			System.out.println("----------------------------------------------------");
			for (Course Course : currentStudent.getCourseEnrolled()) {
				System.out.format("| %-11s| %-36s| %-11s\n", Course.getCourseID(), Course.getCourseName(),Course.getIndex().get(0).getIndexID());
			}
		} else {
			System.out.println("No Courses registered!");
		}
	}

	public void printVacanciesAvaliable(String courseID, String indexID) {
		System.out.println("Vacancies: " + cmngr.checkVacancy(courseID, indexID) + " Slots");
	}

	@SuppressWarnings({ "null", "unused" })
	public boolean changeIndex(String changeCourseID, String changeIndex) {
			//find the index object using course
			Index indexToChange = new Index();
			ArrayList<Course> courseList = new ArrayList<Course>();
			
			ArrayList<Index> indexList = new ArrayList<Index>();
			
			courseList = currentStudent.getCourseEnrolled();
			int courseToChange = 0;
			for(int i = 0; i < courseList.size(); i++)
			{
				if(changeCourseID.equals(courseList.get(i).getCourseID()))
				{
					 courseToChange = i;
					 indexList = courseList.get(i).getIndex();
					 break;
				}
		
			}
			
			for(int i =0; i < indexList.size();i++)
			{
				if(changeIndex.equals(indexList.get(i).getIndexID()))
				{
					indexToChange = indexList.get(i);
					break;
				}
			}

	        //check for timeslot here
	        if(currentStudent.checkClash(indexToChange) == true)
	        {
	        	
	        	return false;
	        }
	        
	        else
	        {
	        	ArrayList<Index> newIndex = new ArrayList<Index>();
	 	        newIndex.add(indexToChange);
	 	        currentStudent.getCourseEnrolled().get(courseToChange).setIndex(newIndex);
	 	        saveStudentsFile();
	 	        return true;
	        }
	        
	       
		
	}

	public boolean swapIndex(String swapCourseID, String swapIndex, String swapStudentName) {
	   
        //find index object using course
		Index indexToSwap = new Index();
		ArrayList<Course> courseList = new ArrayList<Course>();
		
		ArrayList<Index> indexList = new ArrayList<Index>();
		
		courseList = currentStudent.getCourseEnrolled();
		
		int courseToSwap = 0;
		for(int i = 0; i < courseList.size(); i++)
		{
			if(swapCourseID.equals(courseList.get(i).getCourseID()))
			{
				 courseToSwap = i;
				 indexList = courseList.get(i).getIndex();
				 break;
			}
	
		}
		
		for(int i =0; i < indexList.size();i++)
		{
			if(swapIndex.equals(indexList.get(i).getIndexID()))
			{
				indexToSwap = indexList.get(i);
				break;
			}
		}
		
		//get other student's index using course and name
		ArrayList<Student> studentList = getListOfStudents();
		Student otherStudent= new Student();
		
		ArrayList<Course> otherStudentCourseList  = new ArrayList<Course>();
		
		for(int i = 0; i < studentList.size();i++)
		{
			if(swapStudentName.equals(studentList.get(i).getName()))
			{
				otherStudent = studentList.get(i);
				otherStudentCourseList = studentList.get(i).getCourseEnrolled();
				break;
			}
		}
		//check if other student is taking the same course or not
		//if he is taking same course, get his index
		ArrayList<Index> otherStudentIndex = new ArrayList<Index>();
		int otherStudentCourse = 0;
		boolean checkIfSameCourse = false;
		for(int i =0; i < otherStudentCourseList.size();i++)
		
		{
			if(swapCourseID.equals(otherStudentCourseList.get(i)))
			{
				otherStudentCourse = i;
				otherStudentIndex = otherStudentCourseList.get(i).getIndex();
				checkIfSameCourse = true;
				break;
			}
			
			else
			{
				checkIfSameCourse = false;
			}
		
			
		}
		if(checkIfSameCourse == false)
		{
			System.out.println(swapStudentName + "does not have this course!");
			return false;
		}
		
		//check for timeslot and get current student's index object
		
		if(currentStudent.checkClash(otherStudentIndex.get(0)) == true || otherStudent.checkClash(currentStudent.getCourseEnrolled().get(courseToSwap).getIndex().get(0)) == true)
        {
			System.out.println("Clash in timetable, swap is not possible");
        	return false;
        }
		
		else
		{
			currentStudent.getCourseEnrolled().get(courseToSwap).setIndex(otherStudentIndex);
            otherStudent.getCourseEnrolled().get(otherStudentCourse).setIndex(currentStudent.getCourseEnrolled().get(courseToSwap).getIndex()); 
            
            saveStudentsFile();
            return true;
			
		}
		
       
	}
	
//	public boolean checkClash(String courseID, String indexID) {
//		//check if current student timetable clash with new incoming course
//		
//		Course tempcourse = cmngr.findCourseObject(courseID);
//		Index tempindex = tempcourse.findIndexObject(indexID);
//		ArrayList<Lesson> templesson = tempindex.getLessons();
//		String[][] studSchedule = this.currentStudent.getSchedule();
//		
//		
//		for(Lesson lesson: templesson) {
//		
//			int day = lesson.getDay();
//			int start = lesson.getStartTime();
//			int end = lesson.getStartTime()+lesson.getDuration();
//			
//		
//			for(int i = day; i<studSchedule[0].length;i++) {
//				System.out.println();
//			}
//		
//		
//		
//		
//		
//		
//		return false;
//	}

	public void printSchedule() {
		
		currentStudent.populateSchedule();
		
	    try{
	    	Course[][] schedule = this.currentStudent.getSchedule();
	        int rows = schedule.length;
	        int columns = schedule[0].length;
	        String str = "|\tTime\tMon\tTues\tWed\tThurs\tFri\tSat\tSun\t|\n|\t";

	        for(int i=0;i<rows;i++){
	        	
	        	
	        	switch(i) {
	        	
	        	case 0:
	        		str += "0800\t";
	        		break;
	        	case 1:
	        		str += "0830\t ";
	        		break;
	        	case 2:
	        		str += "0930\t";
	        		break;
	        	case 3:
	        		str += "1030\t";
	        		break;
	        	case 4:
	        		str += "1130\t";
	        		break;
	        	case 5:
	        		str += "1230\t";
	        		break;
	        	case 6:
	        		str += "1330\t";
	        		break;
	        	case 7:
	        		str += "1430\t";
	        		break;
	        	case 8:
	        		str += "1530\t";
	        		break;
	        	case 9:
	        		str += "1630\t";
	        		break;
	        	case 10:
	        		str += "1730\t";
	        		break;
	        	}
	        	
	        	for(int j=0;j<columns;j++){
	            	if(schedule[i][j] == null) {
	            		str += "\t";
	            	}
	            	else{
	            		str += schedule[i][j] + "\t";
	            	}
	            }

	            System.out.println(str + "|");
	            str = "|\t";
	        }

	    }catch(Exception e){System.out.println("Matrix is empty!!");}
	}
	
	

	/* ------ Admin Related Methods: Start ------ */
	/**
	 * Adds a new student to the current list of students
	 * 
	 * @return boolean result indicating if the operation is a success or failure;
	 */
	public static boolean addNewStudent(Student student) {
		listOfStudents.add(student);
		saveStudentsFile();
		return true;
	}

	/**
	 * Updates an existing student from the current list of student
	 * 
	 * @return boolean result indicating if the operation is a success or failure;
	 */
	public static boolean updateStudent(Student updateStudent) {
		for (int i = 0; i < listOfStudents.size(); i++) {
			if (listOfStudents.get(i).getMatricNumber().equals(updateStudent.getMatricNumber())) {
				listOfStudents.set(i, updateStudent);
				break;
			}
		}
		saveStudentsFile();
		return true;
	}
	/* ------ Admin Related Methods: End ------ */
}
