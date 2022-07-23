package com.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.entity.UserDetails;
import com.entity.Account;
import com.model.EntityRelationship;

@ManagedBean(name="er",eager=true)
public class ERController {

	 int accid;
	 String acctype;
	 double balance;
	 String username;
	 String password;
	    @EJB(lookup="java:global/Project/EntityModel!com.model.EntityRelationship")
		EntityRelationship ER;
		String response;
		public int getAccid() {
			return accid;
		}
		public void setAccid(int accid) {
			this.accid = accid;
		}
		public String getAcctype() {
			return acctype;
		}
		public void setAcctype(String acctype) {
			this.acctype = acctype;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public EntityRelationship getER() {
			return ER;
		}
		public void setER(EntityRelationship eR) {
			ER = eR;
		}
		public String getResponse() {
			return response;
		}
		public void setResponse(String response) {
			this.response = response;
		}
		public void insert()
		{
			try {
				
				UserDetails U=new UserDetails();
				Account A=new Account();
				U.setUsername(username);
				U.setPassword(password);
				A.setAccid(accid);
				A.setAcctype(acctype);
				A.setBalance(balance);
				response=ER.insertData(U,A);
			}
			catch(Exception e)
			{
				response=e.getMessage();
			}
		}
}
