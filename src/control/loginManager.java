package control;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class loginManager {
	
	public void validateLogin(String password) throws NoSuchAlgorithmException
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
