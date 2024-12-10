package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.IPLTeamDao;
import com.sunbeam.dao.IPLTeamDaoImpl;
import com.sunbeam.dao.PlayerDao;
import com.sunbeam.dao.PlayerDaoImpl;
import com.sunbeam.entities.IPLTeam;
import com.sunbeam.entities.Player;

public class AddPlayerToTeam {
       
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
	

			PlayerDao playerDao=new PlayerDaoImpl();
			System.out.println("Enter Player details - Enter First Name, "
					+ "Enter Last Name , Enter DOB, Enter BattingAvg, "
					+ "Enter wicketTaken");
		     
			
			Player player=new Player(sc.next(),sc.next(),LocalDate.parse(sc.next()),sc.nextDouble(),sc.nextInt());
			System.out.println("Enter Team id :");
			Long teamId=sc.nextLong();
			System.out.println(playerDao.addPlayerToTeam(player, teamId));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
