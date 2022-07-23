package com.controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.ejb.EJB;
import com.model.UserRemote;

@ManagedBean(name="vald",eager=true)

public class LoginValidation implements Serializable{
	/**
	 * 
	 */
	@EJB(lookup = "java:global/Project/UserManager!com.model.UserRemote")
	UserRemote ur;
	private static final long serialVersionUID = 1L;
	 
	   
	
	public String Validate(String us,String pw) throws Exception
	{
		UserData ud=new UserData();
		ud.setUsername(us);
		ud.setPassword(pw);
		
	   try {
			if(ur.LoginValidate(us,pw)==true)
				return "home";
			else
				return "login";
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
		return "login";
	}
}
