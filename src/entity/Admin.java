/**
 * Represents a admin that can access the STARS Application
 * An admin class inherits from a User class
 * @author Wong Chin Hao
 * @version 1.0
 * @since 2020/10/08
 */
package entity;

public class Admin extends User {

	/**
	 * the staff ID of the admin
	 */
	private String staffID;
	
	public Admin() {
		super();
	}

	/**
	 * Constructor to create a new admin given the login ID and login password
	 * @param loginID This admin login ID
	 * @param loginPW This admin login password
	 */
	public Admin(String loginID, String loginPW) {
		super(loginID, loginPW);
	}

	/**
	 * Retrieve the staff ID of the admin
	 * @return this admin staff ID
	 */
	public String getStaffID() {
		return staffID;
	}

	/**
	 * Modify the staff ID of the admin
	 * @param staffID the new staff ID of the admin
	 */
	public void setStaffID(String staffID) {
		this.staffID = staffID;
	}

	}
