package com.sunbeam.dao;

import org.hibernate.*;

import com.sunbeam.entities.IPLTeam;

import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.io.Serializable;

public class IPLTeamDaoImpl implements IPLTeamDao{

	@Override
	public String signUpIPLTeam(IPLTeam iplTeam) {
		 
		String msg="Team Registration Failed";
		
		Session session=getSessionFactory().getCurrentSession();
		
		Transaction tx=session.beginTransaction();
		
		try {
			
		     Serializable teamId=session.save(iplTeam);
		     tx.commit();
		     msg="Team Registered Succesfully"+teamId;
		     
		}catch(RuntimeException e) {
			if(tx!=null) {
				tx.rollback();
			}
			throw e;
		}
		return msg;
	}
       
}
