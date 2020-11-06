package entity;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

abstract class User {
	
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

	String loginID;
	String loginPW;
	
	public static  int validateLogin(String password) throws NoSuchAlgorithmException
	{
		//Boolean isValid = false;
			int studentIndex = -1;
		  
		
		  MessageDigest md = MessageDigest.getInstance("SHA-256");
		    //String text = "Text to hash, cryptographically.";

		    // Change this to UTF-16 if needed
		    md.update(password.getBytes(StandardCharsets.UTF_8));
		    byte[] digest = md.digest();

		    String hex = String.format("%064x", new BigInteger(1, digest));
		    System.out.println(hex);
		     
		    for(int i =0; i < studentList.size;i++)
		    {
		    	String currentPassword = studentList.get(i).getPassword();
		    	 md.update(currentPassword.getBytes(StandardCharsets.UTF_8));
				 byte[] currentDigest = md.digest();

				 String currentHex = String.format("%064x", new BigInteger(1, currentDigest));
				 
				 if(hex.equals(currentHex))
				 {
					 return i;
				 }
		    	
		    }
		    
		    return studentIndex;
		
		//return isValid;
	
	}
	
}
