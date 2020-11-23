package entity;

import java.io.Serializable;
/**
 * Lesson object containing attributes of lessons in a Course/Index
 * @author Jasper Lim
 *
 */
public class Lesson implements Serializable {
	/**
	 * Standardization of serialization 
	 */
    private static final long serialVersionUID = 4L;
/**
 * Type of lesson: Lecture, Lab, Tutorial
 */
	private String type;
	/**
	 * Group of lesson: SSP2,FSP3,SS4 etc.
	 */
	private String group;
	/**
	 * Start time slot of the lesson
	 */
	private int startTime;
	/**
	 * Duration of the lesson, in number of time slots taken up per lesson.
	 */
	private int duration;
	/**
	 * Day of the lesson, starting from 0 as monday
	 */
	private int day;

	/**
	 * Lesson constructor
	 * @param type
	 * @param group
	 * @param day
	 * @param startTime
	 * @param duration
	 */
	public Lesson(String type, String group, int day, int startTime, int duration) {
		this.type = type;
		this.startTime = startTime;
		this.duration = duration;
		this.day = day;
	}

	/*
	 * Get lesson type
	 */
	public String getType() {
		return type;
	}
/**
 * Set lesson type
 * @param type
 */
	public void setType(String type) {
		this.type = type;
	}
/**
 * Get Start time of lesson
 * @return
 */
	public int getStartTime() {
		return startTime;
	}
/**
 * Get end time of lesson
 * @param startTime
 */
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
/**
 * Get duration of lesson
 * @return
 */
	public int getDuration() {
		return duration;
	}
/**
 * Set duration of lesson
 * @param duration
 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
/**
 * Get day of the lesson
 * @return
 */
	public int getDay() {
		return day;
	}
/**
 * Set day of the lesson
 * @param day
 */
	public void setDay(int day) {
		this.day = day;
	}
	/**
	 * Override toString function to print out lesson objects
	 */
	 @Override public String toString() {
		    StringBuilder result = new StringBuilder();
		    String NL = System.getProperty("line.separator");
		    
		    
		    result.append(this.type + NL);
		    result.append(this.group);
		    
		    return result.toString();
	 }
}
