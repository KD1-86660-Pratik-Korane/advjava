package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class CandidateListBean {
       
	String name;
	
	public CandidateListBean() {
		
	}
	
	public List<Candidate> candidateList() throws ServletException{
		List<Candidate> list = new ArrayList<>();
		 
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			list = candDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		return list;
	}
}
