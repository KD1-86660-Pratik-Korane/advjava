package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
       
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  processRequest(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	} 
	 
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		  resp.setContentType("text/html");
		  PrintWriter out=resp.getWriter();
		  
		  String email=req.getParameter("email");
		  String password=req.getParameter("password");
		  
		  try(UserDao userDao=new UserDaoImpl()){
			  User user=userDao.findByEmail(email);
			  if(user!=null && user.getPassword().equals(password)) {
				  
				  Cookie c1=new Cookie("uname",user.getFirstName());
				  c1.setMaxAge(3600);
				  resp.addCookie(c1);
				  Cookie c2=new Cookie("role",user.getRole());
				  c2.setMaxAge(3600);
				  resp.addCookie(c2);
				  
				  HttpSession session=req.getSession();
				  session.setAttribute("curUser", user);
				  if(user.getRole().equals("admin")) {
					  resp.sendRedirect("result");
				  }else {
					  resp.sendRedirect("candlist");
				  }
			  }else {
				  out.println("<h1>User Not found</h1>");
			  }
		  } catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		  
		
	}
}
