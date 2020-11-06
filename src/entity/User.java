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
	
	public static void validateLogin(String password) throws NoSuchAlgorithmException
	{
		//Boolean isValid = false;
		
		  MessageDigest md = MessageDigest.getInstance("SHA-256");
		    //String text = "Text to hash, cryptographically.";

		    // Change this to UTF-16 if needed
		    md.update(password.getBytes(StandardCharsets.UTF_8));
		    byte[] digest = md.digest();

		    String hex = String.format("%064x", new BigInteger(1, digest));
		    System.out.println(hex);
		
		//return isValid;
	
	}
	
}
