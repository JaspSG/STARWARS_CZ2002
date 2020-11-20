package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import static control.fileManager.loadStudentFile;

public class Student extends User implements Serializable {

	String name;
	String matricNumber;
	String nationality;
	String major;
	String email;
	
	String[][] schedule = new String[11][7]; 

	char gender;
	int yearOfStudy;

	Calendar startTime = Calendar.getInstance();
	Calendar endTime = Calendar.getInstance();

	ArrayList<Course> courseTaken = new ArrayList<Course>();
	ArrayList<Course> courseEnrolled = new ArrayList<Course>();
	ArrayList<String> waitList = new ArrayList<String>();

	public Student() {
		super();
		this.populateSchedule();
	}

	public Student(String name, String matricNumber, String nationality, String major, char gender, int yearOfStudy,
			String loginID, String loginPW, String email) {

		super(loginID, loginPW);
		this.name = name;
		this.matricNumber = matricNumber;
		this.nationality = nationality;
		this.major = major;
		this.gender = gender;
		this.yearOfStudy = yearOfStudy;
		this.email = email;
		this.populateSchedule();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMatricNumber() {
		return matricNumber;
	}

	public void setMatricNumber(String matricNumber) {
		this.matricNumber = matricNumber;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public ArrayList<Course> getCourseTaken() {
		return courseTaken;
	}

	public void setCourseTaken(ArrayList<Course> courseTaken) {
		this.courseTaken = courseTaken;
	}

	public ArrayList<Course> getCourseEnrolled() {
		return courseEnrolled;
	}

	public void setCourseEnrolled(ArrayList<Course> courseEnrolled) {
		this.courseEnrolled = courseEnrolled;
	}

	public ArrayList<String> getWaitList() {
		return waitList;
	}

	public void setWaitList(ArrayList<String> waitList) {
		this.waitList = waitList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * to find a student object based on matriculation number
	 * 
	 * @param matricNumber unique key of student object
	 * @return the student object if found, else return null student object
	 */
	public static Student findStudent(String matricNumber) {
		ArrayList<Student> studentArrayList = loadStudentFile(); // load student object to variable
		for (int i = 0; i < studentArrayList.size(); i++) {
			if (studentArrayList.get(i).getMatricNumber().equals(matricNumber)) {
				Student student = studentArrayList.get(i);
				return student;
			}
		}
		System.out.println("Student not found");
		Student emptyStudent = new Student();
		return emptyStudent;
	}
	public boolean accessPeriodValidity() {
		Calendar now = Calendar.getInstance();

		Calendar startTime = this.startTime;
		Calendar endTime = this.endTime;

		if (now.before(endTime) && now.after(startTime)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String[][] getSchedule() {
		return schedule;
	}

	public void setSchedule(String[][] schedule) {
		this.schedule = schedule;
	}
	
	public void populateSchedule() {
		this.schedule[0][0] = "Mon";
		this.schedule[0][1] = "Tues";
		this.schedule[0][2] = "Wed";
		this.schedule[0][3] = "Thurs";
		this.schedule[0][4] = "Fri";
		this.schedule[0][5] = "Sat";
		this.schedule[0][6] = "Sun";
		
		for(Course course: this.courseEnrolled) {
			ArrayList<Index> _tempindex = course.getIndex();
			
			for(Index index :_tempindex) {
				
				ArrayList<Lesson>_templesson = index.getLessons();
				
				for(Lesson lesson: _templesson) {
					
					for(int j=lesson.getStartTime(); j<(lesson.getStartTime()+lesson.getDuration());j++ ) {
					this.schedule[j][lesson.getDay()] = course.getCourseID();
					}
				}
				
			}
		}
	}

}
