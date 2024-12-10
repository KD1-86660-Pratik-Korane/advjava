package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.IPLTeamDao;
import com.sunbeam.dao.IPLTeamDaoImpl;

public class DisplayOwnernAbbrevTester {
	public static void main(String[] args) {
		 
		try (SessionFactory sf = getSessionFactory();Scanner sc=new Scanner(System.in)) {
	              
			IPLTeamDao iplTeamDao=new IPLTeamDaoImpl();
			System.out.println("Enter max_playerAge and batting_avg");
			iplTeamDao.displayOwnernAbbrev(sc.nextInt(),sc.nextDouble()).forEach(iplTeam -> System.out.println("Owner : "+iplTeam.getOwner()+" "+" Abbrevation :"+iplTeam.getAbbreviation()));
			 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
