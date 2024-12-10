package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.IPLTeamDao;
import com.sunbeam.dao.IPLTeamDaoImpl;

public class DeleteTeamTester {
	public static void main(String[] args) {
		 
		try (SessionFactory sf = getSessionFactory();Scanner sc=new Scanner(System.in)) {
	              
			IPLTeamDao iplTeamDao=new IPLTeamDaoImpl();
			System.out.println("Enter userId to delete");
			System.out.println(iplTeamDao.deleteTeam(sc.nextLong()));
			 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
