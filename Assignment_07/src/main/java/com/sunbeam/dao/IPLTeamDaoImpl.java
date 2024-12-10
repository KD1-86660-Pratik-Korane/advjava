package com.sunbeam.dao;

import org.hibernate.*;

import com.sunbeam.entities.IPLTeam;

import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.io.Serializable;
import java.util.List;

public class IPLTeamDaoImpl implements IPLTeamDao{

	@Override
	public String signUpIPLTeam(IPLTeam iplTeam) {
		 
		String msg="Team Registration Failed";
		
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
		     Serializable teamId=session.save(iplTeam);
		     tx.commit();
		     msg="Team Registered Succesfully!"+teamId;
		     
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		return msg;
	}

	@Override
	public List<IPLTeam> getAllTeams() {
		 
        List<IPLTeam> teamList=null;
        String jpql="select t from IPLTeam t";
		Session session=getSessionFactory().getCurrentSession();	
		Transaction tx=session.beginTransaction();
		
		try {			
			  teamList=session.createQuery(jpql, IPLTeam.class).getResultList();
		      tx.commit();		     
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		return teamList;
		 
	}

	@Override
	public List<IPLTeam> getSelectedTeams(int ag, double av) {
		  
		   List<IPLTeam> teamList=null;
		   String jpql="select t from IPLTeam t where t.maxPlayerAge<:age and t.battingAvg>:avg";
	        
			Session session=getSessionFactory().getCurrentSession();	
			Transaction tx=session.beginTransaction();
			
			try {			
				  teamList=session.createQuery(jpql, IPLTeam.class).setParameter("age", ag).setParameter("avg", av).getResultList();
			      tx.commit();		     
			}catch(RuntimeException e) {
				if(tx!=null) {
					tx.rollback();
				}
				throw e;
			}
			return teamList;
		 
	}

	@Override
	public List<IPLTeam> displayOwnernAbbrev(int ag, double av) {
		 List<IPLTeam> teamList=null;
		   String jpql="select new com.sunbeam.entities.IPLTeam(owner,abbreviation) from IPLTeam t where t.maxPlayerAge<:age and t.battingAvg>:avg";
	        
			Session session=getSessionFactory().getCurrentSession();	
			Transaction tx=session.beginTransaction();
			
			try {			
				  teamList=session.createQuery(jpql, IPLTeam.class).setParameter("age", ag).setParameter("avg", av).getResultList();
			      tx.commit();		     
			}catch(RuntimeException e) {
				if(tx!=null) {
					tx.rollback();
				}
				throw e;
			}
			return teamList;
		 
	}

	@Override
	public String updateMaxAge(String tName,int ag) {
		 
		   String msg="max_Age updation failed";
		   String jpql="select t from IPLTeam t where t.name=:Name";
	        IPLTeam team=null;
			Session session=getSessionFactory().getCurrentSession();	
			Transaction tx=session.beginTransaction();
			
			try {			
				  team=session.createQuery(jpql, IPLTeam.class).setParameter("Name", tName).getSingleResult();
				  team.setMaxPlayerAge(ag);
			      tx.commit();
				  msg="max_Age updated Succesfully!";
			}catch(RuntimeException e) {
				if(tx!=null) {
					tx.rollback();
				}
				throw e;
			}
			return msg;
	}

	@Override
	public String deleteTeam(long userId) {
		 
		   String msg="Failed to Delete Team";
		  
	        IPLTeam team=null;
			Session session=getSessionFactory().getCurrentSession();	
			Transaction tx=session.beginTransaction();
			
			try {			
				  team=session.get(IPLTeam.class, userId);
				  if(team!=null) {
					  session.delete(team);
					  msg="Team Deleted Succesfully!";
				  }
			      tx.commit();
			}catch(RuntimeException e) {
				if(tx!=null) {
					tx.rollback();
				}
				throw e;
			}
			return msg;
	}

	 
       
}
