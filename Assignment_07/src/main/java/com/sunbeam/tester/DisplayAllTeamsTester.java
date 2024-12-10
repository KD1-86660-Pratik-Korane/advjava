package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.IPLTeamDao;
import com.sunbeam.dao.IPLTeamDaoImpl;
import com.sunbeam.entities.IPLTeam;

public class DisplayAllTeamsTester {
       
	public static void main(String[] args) {
		 
		try (SessionFactory sf = getSessionFactory()) {
	              
			IPLTeamDao teamList=new IPLTeamDaoImpl();
			teamList.getAllTeams().forEach(System.out::println);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
