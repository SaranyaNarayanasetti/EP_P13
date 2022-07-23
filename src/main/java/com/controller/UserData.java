package com.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.servlet.RequestDispatcher;

import com.entity.UserDetails;
import com.model.UserManager;
import com.model.UserRemote;

@ManagedBean(name = "u", eager = true)
public class UserData 
{
	String username,firstname,lastname,gender,email,mobile,password;
	String response;
	List<UserDetails> list;
	
    @EJB(lookup = "java:global/Project/UserManager!com.model.UserRemote")
	UserRemote UR;
 
   /* public void validate()
    {
    	try
		{
			UserDetails ud = new UserDetails();
			ud.setUsername(username);
			ud.setPassword(password);
			
			boolean response1 = UR.MVCValidate(ud);
			
		}catch(Exception e)
		{
			response = e.getMessage();
		}
    }*/
    
	public void insert()
	{
		try
		{
			UserDetails ud = new UserDetails();
			ud.setUsername(username);
			ud.setFirstname(firstname);
			ud.setLastname(lastname);
			ud.setGender(gender);
			ud.setEmail(email);
			ud.setMobile(mobile);
			ud.setPassword(password);
			
			response = UR.insertData(ud);
			
		}catch(Exception e)
		{
			response = e.getMessage();
		}
	}
	
	public void update()
	{
		try
		{
			UserDetails ud =new UserDetails();
			ud.setUsername(username);
			ud.setFirstname(firstname);
			ud.setLastname(lastname);
			ud.setGender(gender);
			ud.setEmail(email);
			ud.setMobile(mobile);
			ud.setPassword(password);
			
			response = UR.updateData(ud);
			
		}catch(Exception e)
		{
			response = e.getMessage();
		}
	}
	
	public void delete()
	{
		try
		{
			UserDetails ud=new UserDetails();
			ud.setUsername(username);
			ud.setFirstname(firstname);
			ud.setLastname(lastname);
			ud.setGender(gender);
			ud.setEmail(email);
			ud.setMobile(mobile);
			ud.setPassword(password);
			response = UR.deleteData(ud);
			
		}catch(Exception e)
		{
			response = e.getMessage();
		}
	}
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getResponse() {
		return response;
	}
	
	
	public void setResponse(String response) {
		this.response = response;
	}
	
	
	public List<UserDetails> getList() 
	{
		try
		{
			list = UR.getData();
		}catch(Exception e)
		{
			response = e.getMessage();
		}
		return list;
	}
	public void setList(List<UserDetails> list) {
		this.list = list;
	}
	
}
