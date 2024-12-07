package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class AddCandidateBean {
     
	   String name;
	   String party;
	   int votes;
	   int count;
	   
	   public AddCandidateBean() {
		   votes=0;
	   }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	
	   
	 public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void addCandidate() {
		    
		 Candidate c=new Candidate(0,name,party,votes);
		 
		 try(CandidateDao canDao=new CandidateDaoImpl()){
			   count=canDao.save(c);
		 } catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	 }
	   
}
