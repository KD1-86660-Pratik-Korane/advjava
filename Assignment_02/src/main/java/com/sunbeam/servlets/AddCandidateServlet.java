package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@WebServlet("/candidates")
public class AddCandidateServlet extends HttpServlet{
       @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 requestProcess(req,resp);
    }
       @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 requestProcess(req,resp);
    }
	protected void requestProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String name=req.getParameter("name");
		String party=req.getParameter("party");
		int votes=0;
		Candidate c=new Candidate(0,name,party,votes);
		
		try(CandidateDao canDao=new CandidateDaoImpl()){
			int count = canDao.save(c);
			resp.sendRedirect("result");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
}
