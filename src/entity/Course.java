package entity;

import javax.management.ObjectName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {

    private String courseName;

    private String courseID;

    private int au;

    private ArrayList<Index> index;

    private ArrayList<Student> studentsEnrolled;

    public Course(String courseName, String courseID, int au, ArrayList<Index> index, ArrayList<Student> studentsEnrolled){

        this.courseName = courseName;

        this.courseID = courseID;

        this.au = au;

        this.index = index;

        this.studentsEnrolled = studentsEnrolled;
    }

    public String getCourseName(){
        return this.courseName;
    }

    public void setCourseName(String courseName){
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

    public ArrayList<Index> getIndex(){
        return this.index;
    }

    public void setIndex(ArrayList<Index> index){
        this.index = index;
    }

    public ArrayList<Student> getStudentsEnrolled(){
        return this.studentsEnrolled;
    }

    public void setStudentsEnrolled(ArrayList<Student> studentsEnrolled){
        this.studentsEnrolled = studentsEnrolled;
    }

}
