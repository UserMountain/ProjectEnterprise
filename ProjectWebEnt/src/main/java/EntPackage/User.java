package EntPackage;

public class User {
	private int userID;
	private String userName;
	private String userEmail;
	private String userPassword;
	
	public User() {
		super();
	}
	
	public User(int userID, String userName, String userEmail, String userPassword) {
		super();
		this.userID =userID;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	
	
	public int getUserID() {
		return userID;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
}
