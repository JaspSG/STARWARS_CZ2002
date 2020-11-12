package entity;

import javax.management.ObjectName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static control.fileManager.loadCoursesFile;
import static control.fileManager.saveCoursesFile;

public class Course implements Serializable {

    private String courseName;
    private String courseID;
    private int au;
    private ArrayList<Index> index = new ArrayList<Index>();
   
    public Course() {
    	
    }

    public Course(String courseName, String courseID, int au, ArrayList<Index> indexes){

        this.courseName = courseName;

        this.courseID = courseID;

        this.au = au;
        
        this.index = indexes;
    }
    
    public Index findIndexObject(String indexID) {
		for(Index index: this.index) {
			if(index.getIndexID().equals(indexID)) {
				return index;
			}
		}
		System.out.println("Index not found");
		Index emptyindex = new Index();
		return emptyindex;
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

    public static Course findCourse(String courseID) {

        ArrayList<Course> courseList = loadCoursesFile();

        for(Course course: courseList) {
            if(course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        System.out.println("Course not found");
        Course emptyCourse = new Course();
        return emptyCourse;
    }
    public static boolean removeCourse(String courseID){
        ArrayList<Course> courseArrayList = loadCoursesFile();

        for(int i = 0; i < courseArrayList.size(); i++){
            if(courseArrayList.get(i).getCourseID().equals(courseID))
            {
                courseArrayList.remove(i);
            }
        }
        try {
            saveCoursesFile(courseArrayList);
            return true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

}
