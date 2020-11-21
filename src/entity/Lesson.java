package entity;

import java.io.Serializable;

public class Lesson implements Serializable {

	String type;
	int startTime;
	int duration;
	int day;

	public Lesson(String type, int day, int startTime, int duration) {
		this.type = type;
		this.startTime = startTime;
		this.duration = duration;
		this.day = day;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	 @Override public String toString() {
		    StringBuilder result = new StringBuilder();
		    String NL = System.getProperty("line.separator");
		    
		    
		    result.append(this.type);
		    
		    return result.toString();
	 }
}
