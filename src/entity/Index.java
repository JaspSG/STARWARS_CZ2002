package entity;

import java.time.LocalDateTime;

public class Index {
	private int vacancies;
	private String getName;
	private LocalDateTime tutorialSlot_start;
	private LocalDateTime tutorialSlot_end;
	private LocalDateTime labSlot_start;
	private LocalDateTime labSlot_end;
	private LocalDateTime lectureSlot_end;

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

	public LocalDateTime getTutorialSlot_start() {
		return tutorialSlot_start;
	}

	public void setTutorialSlot_start(LocalDateTime tutorialSlot_start) {
		this.tutorialSlot_start = tutorialSlot_start;
	}

	public LocalDateTime getTutorialSlot_end() {
		return tutorialSlot_end;
	}

	public void setTutorialSlot_end(LocalDateTime tutorialSlot_end) {
		this.tutorialSlot_end = tutorialSlot_end;
	}

	public LocalDateTime getLabSlot_start() {
		return labSlot_start;
	}

	public void setLabSlot_start(LocalDateTime labSlot_start) {
		this.labSlot_start = labSlot_start;
	}

	public LocalDateTime getLabSlot_end() {
		return labSlot_end;
	}

	public void setLabSlot_end(LocalDateTime labSlot_end) {
		this.labSlot_end = labSlot_end;
	}

	public LocalDateTime getLectureSlot_end() {
		return lectureSlot_end;
	}

	public void setLectureSlot_end(LocalDateTime lectureSlot_end) {
		this.lectureSlot_end = lectureSlot_end;
	}

	public boolean checkVacancy() {
		return false; // temporary return value atm
	}
}
