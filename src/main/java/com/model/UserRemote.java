package com.model;

import java.util.List;

import javax.ejb.Remote;

import com.entity.UserDetails;

@Remote
public interface UserRemote 
{
	public String insertData(UserDetails ud)throws Exception;
	public List<UserDetails> getData() throws Exception;
	public String updateData(UserDetails ud)throws Exception;
	public String deleteData(UserDetails ud)throws Exception;
	public boolean LoginValidate(String us,String pw) throws Exception;
}
