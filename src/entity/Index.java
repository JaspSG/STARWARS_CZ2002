package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Index implements Serializable {
	private int vacancies;
	private String indexID;
	private String tutorialSlot;
	private String labSlot;
	private String lectureSlot;

	public Index(String indexID) {
		this.indexID=indexID;
	}
	
	public int getVacancies() {
		return vacancies;
	}

	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
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
		return false; // temporary return value atm
	}
}
