package entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Index implements Serializable {
	private int vacancies;
	private String getName;
	private LocalDateTime tutorialSlot;
	private LocalDateTime labSlot;
	private LocalDateTime lectureSlot;

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

	public LocalDateTime getTutorialSlot() {
		return tutorialSlot;
	}

	public void setTutorialSlot(LocalDateTime tutorialSlot) {
		this.tutorialSlot = tutorialSlot;
	}

	public LocalDateTime getLabSlot() {
		return labSlot;
	}

	public void setLabSlot(LocalDateTime labSlot) {
		this.labSlot = labSlot;
	}

	public LocalDateTime getLectureSlot() {
		return lectureSlot;
	}

	public void setLectureSlot(LocalDateTime lectureSlot) {
		this.lectureSlot = lectureSlot;
	}

	public boolean checkVacancy() {
		return false; // temporary return value atm
	}
}
