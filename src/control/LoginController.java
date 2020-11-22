package control;

import java.util.ArrayList;
import java.util.Scanner;

import boundary.AdminUI;
import entity.Admin;
import entity.Student;
import entity.User;

public class LoginController {

	Admin admin = new Admin();
	Student student = new Student();
	ArrayList<Admin> adminList = new ArrayList<Admin>();
	ArrayList<Student> studentList = new ArrayList<Student>();
	Scanner sc = new Scanner(System.in);
	
	int _typeOfUser;


	private String loginID;
	private String password;
	
	
	public LoginController(){
		
	}
	
	public LoginController(int _typeOfUser, String loginID, String password){
		//Admin
		
		this.loginID=loginID;
		this.password=password;
		this._typeOfUser=_typeOfUser;

		
		if(_typeOfUser == 1) {
			this.adminList = fileManager.loadAdminFile();
			for(Admin _tempadmin: this.adminList) {
				if(_tempadmin.getLoginID().equals(this.loginID) == true) {
					this.admin = _tempadmin;
					break;
				}
			}
			
		}
		//Student
		else if(_typeOfUser == 2){
			this.studentList = fileManager.loadStudentFile();
			for(Student _tempstudent: this.studentList) {
				if(_tempstudent.getLoginID().equals(loginID)) {
					this.student=_tempstudent;

				}
			}

		}
	}
	
	public boolean validateUser() {
		if (_typeOfUser==1) {
			if(this.admin == null) {
				return false;
			}
			if(admin.validateLogin(this.loginID, this.password)==true) {
				return true;
			}
			else {
				System.out.println("Wrong Login Information");
			}
		
		}
		if(_typeOfUser==2) {
			if(this.student == null) {
				return false;
			}
			if(student.validateLogin(this.loginID, this.password)==true) {
				if(student.accessPeriodValidity()==true) {
					return true;	
				}
				else {
					System.out.println("Invalid access period");
				}
				
			}
			else {
				System.out.println("Wrong login information");
			}
		}
		return false;
	}
	
	public String getLoginID() {
		return loginID;
	}
}
