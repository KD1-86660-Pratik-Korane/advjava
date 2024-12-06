package com.sunbeam.beans;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class LoginBean {
       String email;
       String password;
       private User user;
       
       public LoginBean() {
    	   
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
       
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean authenticateUser() throws ServletException {
    	 
		  
		  try(UserDao userDao=new UserDaoImpl()){
			  User Dbuser=userDao.findByEmail(email);
			  if(Dbuser!=null && Dbuser.getPassword().equals(password)) {
				   this.user=Dbuser;
			  } 
		  } catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		  return false;
    }
}
