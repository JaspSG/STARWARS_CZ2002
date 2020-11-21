package entity;

public class Schedule {
	
	Lesson[][] schedule = new Lesson[10][5];
	
	Schedule() {
		
	}
	
	public Lesson[][] getSchedule() {
		return schedule;
	}

	public void setSchedule(Lesson[][] schedule) {
		this.schedule = schedule;
	}
}
