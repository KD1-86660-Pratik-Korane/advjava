package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteCandidateBean {
	
	   int candId;
       int count;
       
       public DeleteCandidateBean() {
    	   
       }

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
       
     public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	public void deleteCandidate() {
    	 try(CandidateDao canDao=new CandidateDaoImpl()){
    	     this.count=canDao.deleteById(candId);
    	 } catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
     }
}
