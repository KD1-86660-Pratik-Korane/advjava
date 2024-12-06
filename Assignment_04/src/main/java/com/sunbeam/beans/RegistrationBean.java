package com.sunbeam.beans;

import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class RegistrationBean {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String birth;
	int count;
	
	public RegistrationBean() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int registerUser() throws ServletException {
		String firstName=this.firstName;
		String lastName=this.lastName;
		String email=this.email;
		String password=this.password;
		String date=this.birth;
		Date dob=Date.valueOf(date);
		int status=0;
		String role="voter";
		User u=new User(0,firstName,lastName,email,password,dob,status,role);
		  
		try(UserDao userDao=new UserDaoImpl()){
			 this.count=userDao.save(u);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		return count;
	}
}
