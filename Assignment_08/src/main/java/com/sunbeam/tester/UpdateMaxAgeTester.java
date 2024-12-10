package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.IPLTeamDao;
import com.sunbeam.dao.IPLTeamDaoImpl;

public class UpdateMaxAgeTester {
	public static void main(String[] args) {
		 
		try (SessionFactory sf = getSessionFactory();Scanner sc=new Scanner(System.in)) {
	              
			IPLTeamDao iplTeamDao=new IPLTeamDaoImpl();
			System.out.println("Enter Team name and new Max_Age: ");
			System.out.println(iplTeamDao.updateMaxAge(sc.next(),sc.nextInt()));
			 
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
