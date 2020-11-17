package entity;

import control.fileManager;

import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class User implements Serializable {
	
	String loginID;
	String loginPW;
	
	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getLoginPW() {
		return loginPW;
	}

	public void setLoginPW(String loginPW) {
		this.loginPW = loginPW;
	}
	

	public User() {
		
	}
	
	public User(String loginID, String loginPW)
	{
		this.loginID = loginID;
		this.loginPW = loginPW;
	}

	public static int validateLogin(String username,String password) throws NoSuchAlgorithmException
	{
		//load file
		fileManager fm = new fileManager();
		ArrayList<Student> studentList = fileManager.loadStudentFile();

		//Boolean isValid = false;
			int studentIndex = -1;
			System.out.println("User input: " + username +" " +password);
		  
			String userPW = hashString(password);
		    
		    for(int i =0; i < studentList.size();i++)
		    {
		    	//check for username 
		    	if(Objects.equals(username, studentList.get(i).getLoginID()))
		    	{
		    		//get password of that account
		    		String currentPassword = studentList.get(i).getLoginPW();
			    	//System.out.println("Data: " + currentPassword);
			    	
					 String dataPW = hashString(currentPassword);
					 
					 //compare the hashed user pw with pw in file
		    		if(Objects.equals(userPW, dataPW))// --> true
					 {
					 	 // CHECK ACCESS PERIOD
						 Calendar startTime = studentList.get(i).getStartTime();
						 Calendar endTime = studentList.get(i).getEndTime();

						 Calendar now = Calendar.getInstance(); // get today date

		    			 System.out.println("Login Successful!");
						 return i;
					 }
		    	}
		    	
		    }
		    
		    return studentIndex;
		
		//return isValid;
	
	}

	public static int validateLoginAdmin(String username,String password) throws NoSuchAlgorithmException
	{
		//load file
		fileManager fm = new fileManager();
		ArrayList<Admin> adminList = fileManager.loadAdminFile();

		//Boolean isValid = false;
		int adminIndex = -1;
		System.out.println("User input: " + username +" " +password);

		String userPW = hashString(password);

		for(int i =0; i < adminList.size();i++)
		{
			//check for username
			if(Objects.equals(username, adminList.get(i).getLoginID()))
			{
				//get password of that account
				String currentPassword = adminList.get(i).getLoginPW();
				//System.out.println("Data: " + currentPassword);

				String dataPW = hashString(currentPassword);

				//compare the hashed user pw with pw in file
				if(Objects.equals(userPW, dataPW))// --> true
				{
					System.out.println("Login Successful!");
					return i;
				}
			}

		}

		return adminIndex;

		//return isValid;
	}
	
	public static String hashString(String password) throws NoSuchAlgorithmException
	{
		  MessageDigest md = MessageDigest.getInstance("SHA-256");
		    //String text = "Text to hash, cryptographically.";

		    // Change this to UTF-16 if needed
		    md.update(password.getBytes(StandardCharsets.UTF_8));
		    byte[] digest = md.digest();

		    String hex = String.format("%064x", new BigInteger(1, digest));
		    return hex;
	}
	
}
