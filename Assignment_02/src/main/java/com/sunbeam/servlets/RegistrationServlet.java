package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet{
       
	   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 processRequest(req,resp);
	}
	   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 processRequest(req,resp);
	}
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		 
		String firstName=req.getParameter("firstName");
		String lastName=req.getParameter("lastName");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String dobDate=req.getParameter("dob");
		String date=req.getParameter("dob");
		Date dob=Date.valueOf(date);
		int status=0;
		String role="voter";

		User u=new User(0,firstName,lastName,email,password,dob,status,role);
		  Cookie c1=new Cookie("uname",u.getFirstName());
		  c1.setMaxAge(3600);
		  resp.addCookie(c1);
		  Cookie c2=new Cookie("role",u.getRole());
		  c2.setMaxAge(3600);
		  resp.addCookie(c2);
		  
		try(UserDao userDao=new UserDaoImpl()){
			int count=userDao.save(u);
			resp.setContentType("text/html");
			PrintWriter out=resp.getWriter();
			resp.sendRedirect("candlist");
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
}
