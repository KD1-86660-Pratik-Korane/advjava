package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.PlayerDao;
import com.sunbeam.dao.PlayerDaoImpl;
import com.sunbeam.entities.Player;

public class GetAllPlayersFromTeam {
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
	        
			PlayerDao playerDao=new PlayerDaoImpl();
            System.out.println("Enter Team Id : ");
            Long teamId=sc.nextLong();
            playerDao.getAllPlayers(teamId).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
