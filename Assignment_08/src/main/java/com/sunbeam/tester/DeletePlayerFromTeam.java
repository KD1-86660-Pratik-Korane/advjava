package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.PlayerDao;
import com.sunbeam.dao.PlayerDaoImpl;
import com.sunbeam.entities.Player;

public class DeletePlayerFromTeam {
        
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
	        
			PlayerDao playerDao=new PlayerDaoImpl();
			System.out.println("Enter PlayerId and TeamId");
			 
			System.out.println(playerDao.deletePlayerFromTeam(sc.nextLong(),sc.nextLong()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
