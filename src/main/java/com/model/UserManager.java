 package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.entity.UserDetails;

import com.entity.*;

@Stateless
public class UserManager implements UserRemote 
{
	ResultSet rs = null;
	public boolean LoginValidate(String us,String pw) throws Exception
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root","2000031263");
		PreparedStatement ps = con.prepareStatement("select count(*) from userdata where username = ? and password = ?");
		ps.setString(1, us);
		ps.setString(2, pw);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
		{
			if(rs.getInt(1) == 1)
			{
				return true;
			}
			else
			{	
				return false;
			}
		}
		return false;
	}
	
	
	@Override
	public String insertData(UserDetails ud) throws Exception 
	{
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "2000031263");
		PreparedStatement ps = con.prepareStatement("insert into userdata values(?,?,?,?,?,?,?)");
		ps.setString(1, ud.getUsername());
		ps.setString(2, ud.getFirstname());
		ps.setString(3, ud.getLastname());
		ps.setString(4, ud.getGender());
		ps.setString(5, ud.getEmail());
		ps.setString(6, ud.getMobile());
		ps.setString(7, ud.getPassword());
		ps.execute();
		
		con.close();
		
		return "Record Saved Successfully...";
	}

	
	@Override
	public List<UserDetails> getData() throws Exception 
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "2000031263");
		PreparedStatement ps = con.prepareStatement("select * from userdata");
		ResultSet rs = ps.executeQuery();
		List<UserDetails> L = new ArrayList<UserDetails>();
		while(rs.next())
		{
			UserDetails ud=new UserDetails();
			ud.setUsername(rs.getString(1));
			ud.setFirstname(rs.getString(2));
			ud.setLastname(rs.getString(3));
			ud.setGender(rs.getString(4));
			ud.setEmail(rs.getString(5));
			ud.setMobile(rs.getString(6));
			
			L.add(ud);
		}
		con.close();
		return L;
	}

	@Override
	public String updateData(UserDetails ud) throws Exception 
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "2000031263");
		PreparedStatement ps = con.prepareStatement("update userdata set firstname=?,lastname=?,gender=?,email=?,mobile=?,password=? where username=?");
		ps.setString(1, ud.getUsername());
		ps.setString(2, ud.getFirstname());
		ps.setString(3, ud.getLastname());
		ps.setString(4, ud.getGender());
		ps.setString(5, ud.getEmail());
		ps.setString(6, ud.getMobile());
		ps.setString(7, ud.getPassword());
		
		ps.execute();
		
		con.close();
		return "Record Updated Successfully...";
	}

	@Override
	public String deleteData(UserDetails ud) throws Exception 
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "20000312632");
		PreparedStatement ps = con.prepareStatement("delete from userdata where username=?");
		ps.setString(1, ud.getUsername());
		ps.execute();
		con.close();
		return "Record Deleted Successfully...";
	}
	
}
