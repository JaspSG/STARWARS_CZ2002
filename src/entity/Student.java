package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Student implements Serializable {
	
	String name;
	String matricNumber;
	String nationality;
	String major;
	String loginID;
	String loginPW;
	
	char gender;
	int yearOfStudy;
	
	Calendar startTime;
	Calendar endTime;
	
	ArrayList<Integer> courseTaken;
	ArrayList<Course> courseEnrolled;
	ArrayList<Course> waitList;

	public Student(String name, String matricNumber, String nationality, String major, String loginID, String loginPW, char gender, int yearOfStudy) {
		
		this.name=name;
		this.matricNumber=matricNumber;
		this.nationality=nationality;
		this.major=major;
		this.loginID=loginID;
		this.loginPW=loginPW;
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
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getLoginPW() {
		return loginPW;
	}
	public void setLoginPW(String loginPW) {
		this.loginPW = loginPW;
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
	public ArrayList<Integer> getCourseTaken() {
		return courseTaken;
	}
	public void setCourseTaken(ArrayList<Integer> courseTaken) {
		this.courseTaken = courseTaken;
	}
	public ArrayList<Course> getCourseEnrolled() {
		return courseEnrolled;
	}
	public void setCourseEnrolled(ArrayList<Course> courseEnrolled) {
		this.courseEnrolled = courseEnrolled;
	}
	public ArrayList<Course> getWaitList() {
		return waitList;
	}
	public void setWaitList(ArrayList<Course> waitList) {
		this.waitList = waitList;
	}
		
}
