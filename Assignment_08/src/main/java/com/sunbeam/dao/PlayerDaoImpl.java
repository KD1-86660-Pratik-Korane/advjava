package com.sunbeam.dao;

import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.IPLTeam;
import com.sunbeam.entities.Player;

public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String addPlayerToTeam(Player player, Long teamId) {
		 String msg="Failed to Add player";
		 Session session=getSessionFactory().getCurrentSession();
			
			Transaction tx=session.beginTransaction();
			
			try {
				 IPLTeam team=session.get(IPLTeam.class, teamId);
				 if(team!=null) {
					 team.addPlayer(player);
					 session.persist(player);
				 }
			    
				 tx.commit();
			     msg="Player Added Succesfully!";
			}catch(RuntimeException e) {
				if(tx!=null) {
					tx.rollback();
				}
				throw e;
			}
			return msg;
	}

	@Override
	public List<Player> getAllPlayers(Long teamId) {
		 
		List<Player> players = null;
		IPLTeam team=null;
	 
		Session session = getSessionFactory().getCurrentSession();
	 
		Transaction tx = session.beginTransaction();
		try {
			 
			team=session.get(IPLTeam.class, teamId);
			Hibernate.initialize(team.getPlayers());
			players=team.getPlayers();
		 
			tx.commit();
		} catch (RuntimeException e) {
			 
			if (tx != null)
				tx.rollback();
			 
			throw e;
		}

		return players; 
	}

	@Override
	public String deletePlayerFromTeam(Long playerId,Long teamId) {
		   
		 String msg="Failed to Remove player";
		 Session session=getSessionFactory().getCurrentSession();
			 
			Transaction tx=session.beginTransaction();
			
			try {
				 IPLTeam team=session.get(IPLTeam.class, teamId);
				 Player player=session.get(Player.class, playerId);
				 
				 if(team!= null && player!=null) {
					 team.removePlayer(player);
				 }
				 
				 tx.commit();
			     msg="Player Removed Succesfully!";
			}catch(RuntimeException e) {
				if(tx!=null) {
					tx.rollback();
				}
				throw e;
			}
			return msg;
	}

}
