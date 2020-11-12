package entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static control.fileManager.loadCoursesFile;
import static control.fileManager.saveCoursesFile;

public class Index implements Serializable {
	private int totalSize;
	private int currentSize;
	private String indexID;
	private String tutorialSlot;
	private String labSlot;
	private String lectureSlot;
	private ArrayList<Student> studentsEnrolled;
	private ArrayList<Lesson> lessons;
	private Queue<Student> waitlist = new LinkedList<Student>();

	public Index() {}

	public Index(String indexID) {
		this.indexID=indexID;
	}

	public Index(String indexID, int totalSize, ArrayList<Lesson> lessons) {

		this.indexID=indexID;

		this.totalSize=totalSize;

		this.lessons = lessons;
	}
	
	public void printQueue() {
		
		for(Student student: this.waitlist) {
			System.out.println(student.getName());
		}
		
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
	
	public Student removeStudentFromWaitlist() {
		
		Student tempstudent = this.waitlist.remove();
		return tempstudent;
	}

	public boolean checkVacancy() {		
		if (totalSize - currentSize > 0)
			return true; 
		else return false;
	}

	/**
	 * To find an index object based on indexID
	 * @param courseID The courseID of the index object
	 * @param indexID The indexID of the index object
	 * @return the index object if found, else return null index object
	 */
	public static Index findIndex(String courseID, String indexID) {
		ArrayList<Course> courseArrayList = loadCoursesFile(); // load course object to variable
		for(int i = 0; i < courseArrayList.size(); i++)
		{
			if(courseArrayList.get(i).getCourseID().equals(courseID))
			{
				ArrayList<Index> indexArrayList = courseArrayList.get(i).getIndex();
				for(int j = 0; j < indexArrayList.size(); j++){
					if(indexArrayList.get(i).getIndexID().equals(indexID)){
						Index index = indexArrayList.get(i);
						return index;
					}
				}
			}
		}
		System.out.println("Index not found");
		Index emptyIndex = new Index();
		return emptyIndex;
	}

	/**
	 * To remove an index object based on indexID
	 * @param courseID The courseID of the index object
	 * @param indexID The indexID of the index object
	 * @return true or false depending if is success
	 */
	public static boolean removeIndex(String courseID, String indexID){
		ArrayList<Course> courseArrayList = loadCoursesFile();

		for(int i = 0; i < courseArrayList.size(); i++){
			if(courseArrayList.get(i).getCourseID().equals(courseID))
			{
				ArrayList<Index> indexArrayList = courseArrayList.get(i).getIndex();
				for(int j = 0; j < indexArrayList.size(); j++){
					if(indexArrayList.get(i).getIndexID().equals(indexID)){
						indexArrayList.remove(i);
					}
				}
			}
		}
		try {
			saveCoursesFile(courseArrayList);
			return true;
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;
	}
}
