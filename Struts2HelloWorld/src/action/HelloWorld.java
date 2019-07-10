package action;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorld  extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message,userName;
	
	public String execute()
	{
		setMessage("Hello " + getUserName());
		return "SUCCESS";
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
