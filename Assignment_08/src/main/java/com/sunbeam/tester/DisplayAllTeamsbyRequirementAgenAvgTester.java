package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.IPLTeamDao;
import com.sunbeam.dao.IPLTeamDaoImpl;

public class DisplayAllTeamsbyRequirementAgenAvgTester {
	public static void main(String[] args) {
		 
		try (SessionFactory sf = getSessionFactory();Scanner sc=new Scanner(System.in)) {
	              
			IPLTeamDao iplTeamDao=new IPLTeamDaoImpl();
			System.out.println("Enter max_playerAge and batting_avg");
			iplTeamDao.getSelectedTeams(sc.nextInt(),sc.nextDouble()).forEach(System.out::println);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
