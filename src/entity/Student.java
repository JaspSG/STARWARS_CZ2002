package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Student extends User implements Serializable {
	
	String name;
	String matricNumber;
	String nationality;
	String major;
	
	char gender;
	int yearOfStudy;
	
	Calendar startTime;
	Calendar endTime;
	
	ArrayList<Course> courseTaken;
	ArrayList<Course> courseEnrolled;
	ArrayList<String> waitList;
	
	public Student() {
		
	}

	public Student(String name, String matricNumber, String nationality, String major , char gender, int yearOfStudy, String loginID, String loginPW) {
		
		
		super(loginID, loginPW);
		this.name=name;
		this.matricNumber=matricNumber;
		this.nationality=nationality;
		this.major=major;
		this.gender=gender;
		this.yearOfStudy=yearOfStudy;
		
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
	public ArrayList<String> getCourseTaken() {
		return courseTaken;
	}
	public void setCourseTaken(ArrayList<String> courseTaken) {
		this.courseTaken = courseTaken;
	}
	public ArrayList<String> getCourseEnrolled() {
		return courseEnrolled;
	}
	public void setCourseEnrolled(ArrayList<String> courseEnrolled) {
		this.courseEnrolled = courseEnrolled;
	}
	public ArrayList<String> getWaitList() {
		return waitList;
	}
	public void setWaitList(ArrayList<String> waitList) {
		this.waitList = waitList;
	}
		
}
