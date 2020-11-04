package entity;

import java.time.LocalDateTime;

public class Index {
	private int vacancies;
	private String getName;
	private String tutorialSlot;
	private String labSlot;
	private String lectureSlot;

	public int getVacancies() {
		return vacancies;
	}

	public void setVacancies(int vacancies) {
		this.vacancies = vacancies;
	}

	public String getGetName() {
		return getName;
	}

	public void setGetName(String getName) {
		this.getName = getName;
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
