package entity;

import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseName;

    private String courseID;

    private int au;

    private ArrayList<Object> index;

    private ArrayList<Object> studentsEnrolled;

    public Course(String courseName, String courseID, int au, ArrayList<Object> index, ArrayList<Object> studentsEnrolled){

        this.courseName = courseName;

        this.courseID = courseID;

        this.au = au;

        this.index = index;

        this.studentsEnrolled = studentsEnrolled;
    }

    public String getCourseName(){
        return this.courseName;
    }

    public void setCourseName(String courseID){
        this.courseName = courseName;
    }

    public String getCourseID(){
        return this.courseID;
    }

    public void setCourseID (String courseID){
        this.courseID = courseID;
    }

    public int getAu(){
        return this.au;
    }

    public void setAu(int au){
        this.au = au;
    }

    public ArrayList<Object> getIndex(){
        return this.index;
    }

    public void setIndex(ArrayList<Object> index){
        this.index = index;
    }

    public ArrayList<Object> getStudentsEnrolled(){
        return this.studentsEnrolled;
    }

    public void setStudentsEnrolled(ArrayList<Object> studentsEnrolled){
        this.studentsEnrolled = studentsEnrolled;
    }

}