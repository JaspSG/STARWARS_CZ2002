/**
 * Represents a Index Group of a Course Object which a Student can take
 * @author Quah Dian Wei
 * @version 1.0
 * @since 2020/10/08
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static control.fileManager.loadCoursesFile;
import static control.fileManager.saveCoursesFile;

public class Index implements Serializable {
	/**
	 * The total size allowed of the index group
	 */
	private int totalSize = 5;
	/**
	 * The current size of the index group based on the number of student enrolled
	 */
	private int currentSize = 0;
	/**
	 *
	 */
	private String indexID;
	private ArrayList<Student> studentsEnrolled = new ArrayList<Student>();
	private ArrayList<Lesson> lessons = new ArrayList<Lesson>();
	private Queue<Student> waitlist = new LinkedList<Student>();

	public Index() {
	}

	public Index(String indexID) {
		this.indexID = indexID;
	}

	public Index(String indexID, int totalSize, ArrayList<Lesson> lessons) {

		this.indexID = indexID;

		this.totalSize = totalSize;

		this.lessons = lessons;
	}
	
	public void addToLessons(Lesson lesson) {
		this.lessons.add(lesson);
	}

	public void printQueue() {

		for (Student student : this.waitlist) {
			System.out.println(student.getName());
		}

	}

	public void printStudentsEnrolled() {

		if (studentsEnrolled.isEmpty()) {
			System.out.println("No students enrolled in this Index");
		}

		for (Student student : this.studentsEnrolled) {
			System.out.println(
					"Student Name: " + student.getName() + "\nStudent Matric Number: " + student.getMatricNumber());
		}
	}

	public void addStudentToEnrolled(Student student) {
		this.studentsEnrolled.add(student);
		this.currentSize++;
	}

	public void removeStudentFromEnrolled(Student student) {
		for (int i = 0; i < this.studentsEnrolled.size(); i++) {
			if (studentsEnrolled.get(i).getMatricNumber().equals(student.getMatricNumber())) {
				studentsEnrolled.remove(i);
			}
		}
		this.currentSize--;
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

	public void addStudentToWaitlist(Student student) {
		this.waitlist.add(student);
	}

	public Student removeStudentFromWaitlist() {

		Student tempstudent = this.waitlist.remove();
		return tempstudent;
	}

	public int checkVacancy() {
		int vacancy = this.totalSize - this.currentSize;
		return vacancy;
	}

	/**
	 * To remove an index object based on indexID
	 * 
	 * @param courseID The courseID of the index object
	 * @param indexID  The indexID of the index object
	 * @return true or false depending if is success
	 */
	public static boolean removeIndex(String courseID, String indexID) {
		ArrayList<Course> courseArrayList = loadCoursesFile();

		for (int i = 0; i < courseArrayList.size(); i++) {
			if (courseArrayList.get(i).getCourseID().equals(courseID)) {
				ArrayList<Index> indexArrayList = courseArrayList.get(i).getIndex();
				for (int j = 0; j < indexArrayList.size(); j++) {
					if (indexArrayList.get(i).getIndexID().equals(indexID)) {
						indexArrayList.remove(i);
					}
				}
			}
		}
		try {
			saveCoursesFile(courseArrayList);
			return true;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;
	}
	
	 @Override public String toString() {
		    StringBuilder result = new StringBuilder();
		    String NL = System.getProperty("line.separator");
		    
		    
		    result.append(this.indexID);
		    
		    return result.toString();
	 }
}
