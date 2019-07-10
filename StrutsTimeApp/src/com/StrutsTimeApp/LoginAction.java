package com.StrutsTimeApp;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5588374487038737901L;

	public String execute() throws Exception{
   	 System.out.println("---Login---");
   	return "success";
   }
}
