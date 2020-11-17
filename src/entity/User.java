package entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

	public User(String loginID, String loginPW) {
		this.loginID = loginID;
		this.loginPW = loginPW;
	}

	public boolean validateLogin(String username, String password) throws NoSuchAlgorithmException {
		String userPW = hashString(password);
		System.out.println(userPW);
		if (userPW.equals(this.loginPW)) {
			return true;
		} else {
			return false;
		}
	}

	public static String hashString(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		// String text = "Text to hash, cryptographically.";

		// Change this to UTF-16 if needed
		md.update(password.getBytes(StandardCharsets.UTF_8));
		byte[] digest = md.digest();

		String hex = String.format("%064x", new BigInteger(1, digest));
		return hex;
	}

}
