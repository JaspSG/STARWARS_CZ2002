package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Queue;

public class Index implements Serializable {
	private int totalSize;
	private int currentSize;
	private String indexID;
	private String tutorialSlot;
	private String labSlot;
	private String lectureSlot;
	private ArrayList<Student> studentsEnrolled;
	private ArrayList<Lesson> lessons;
	private Queue<Student> waitlist;

	public Index() {}

	public Index(String indexID) {
		this.indexID=indexID;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getCurrentSize() {
		return currentSize;
	}

	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}

	public String getIndexID() {
		return indexID;
	}

	public void setIndexID(String indexID) {
		this.indexID = indexID;
	}

	public String getTutorialSlot() {
		return tutorialSlot;
	}

	public void setTutorialSlot(String tutorialSlot) {
		this.tutorialSlot = tutorialSlot;
	}

	public String getLabSlot() {
		return labSlot;
	}

	public void setLabSlot(String labSlot) {
		this.labSlot = labSlot;
	}

	public String getLectureSlot() {
		return lectureSlot;
	}

	public void setLectureSlot(String lectureSlot) {
		this.lectureSlot = lectureSlot;
	}

	public ArrayList<Student> getStudentsEnrolled() {
		return studentsEnrolled;
	}

	public void setStudentsEnrolled(ArrayList<Student> studentsEnrolled) {
		this.studentsEnrolled = studentsEnrolled;
	}

	public ArrayList<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(ArrayList<Lesson> lessons) {
		this.lessons = lessons;
	}

	public Queue<Student> getWaitlist() {
		return waitlist;
	}

	public void setWaitlist(Queue<Student> waitlist) {
		this.waitlist = waitlist;
	}

	public void addwaitlist(Student student) {
		this.waitlist.add(student);
	}
	
	public void removewaitlist() {
		this.waitlist.remove();
	}

	public boolean checkVacancy() {		
		if (totalSize - currentSize > 0)
			return true; 
		else return false;
	}
}
