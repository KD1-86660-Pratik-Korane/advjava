package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet{
       
	   @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/html");
		 PrintWriter out=resp.getWriter();
		 out.println("<html>");
		 out.println("<head>");
		 out.println("<title>Student Info</title>");
		 out.println("</head>");
		 out.println("<body style=\"background-color: pink;\">");
		 out.println("<h1>Student Info</h1>");
		 out.println("<h3>FirstName : Pratik</h3>");
		 out.println("<h3>LastName : Korane</h3>");
		 out.println("<h3>Qualification : B.Tech</h3>");
		 out.println("<h3>University Name: Shivaji University</h3>");
		 out.println("<h3>Birth Date : 20-10-2002</h3>");
		 out.println("</body>");
		 out.println("</html>");
	}
}
