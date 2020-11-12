package entity;

import java.io.Serializable;

public class Lesson implements Serializable{

	String type;
	String startTime;
	String endTime;
	int day;

	public Lesson(String type, String startTime, String endTime, int day) {
		this.type = type;
		this.startTime = startTime;
		this.endTime = endTime;
		this.day = day;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
}
