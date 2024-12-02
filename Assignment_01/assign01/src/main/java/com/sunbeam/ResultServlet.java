package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.pojo.Marks;

@WebServlet("/result")
public class ResultServlet extends HttpServlet{
       
   private ArrayList<Marks> result;
	   
	   @Override
	public void init(ServletConfig config) throws ServletException {
		 super.init(config);
		 result=new ArrayList<>();
		 result.add(new Marks("Java Programming",80.0));
		 result.add(new Marks("Web programming",85.0));
		 result.add(new Marks("Database technologies",83.0));	 
	}
	   
	   @Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			 resp.setContentType("text/html");
			 PrintWriter out=resp.getWriter();
			 
			 for(Marks m:result) {
				 out.println("<tr>");
				 out.printf("<td>%s<td>\r\n",m.getSubject());
				 out.printf("<td>%.2f<td>\r\n",m.getMarks());
				 out.println("<br/>");
			 }
		}
}
