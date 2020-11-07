package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Index implements Serializable {
	private int totalSize;
	private int currentSize;
	private String indexID;
	private String tutorialSlot;
	private String labSlot;
	private String lectureSlot;

	public Index(String indexID) {
		this.indexID=indexID;
	}
	
	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalsize) {
		this.totalSize = totalsize;
	}
	
	public int getCurrentSize() {
		return this.currentSize;
	}

	public void setCurrentSize(int currentsize) {
		this.currentSize = currentsize;
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

	public boolean checkVacancy() {		
		if (totalSize - currentSize > 0)
			return true; 
		else return false;
	}
}
