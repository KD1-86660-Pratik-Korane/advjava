package com.sunbeam.tester;
import org.hibernate.SessionFactory;
import com.sunbeam.dao.IPLTeamDao;
import com.sunbeam.dao.IPLTeamDaoImpl;
import com.sunbeam.entities.IPLTeam;
import com.sunbeam.utils.HibernateUtil;
import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

import java.time.LocalDate;
import java.util.Scanner;

public class  IPLTeamTester {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
	
			IPLTeamDao iplTeamDao=new IPLTeamDaoImpl();
			System.out.println("Enter Team details - Enter Team Name, "
					+ "Enter Abbreviation , Enter owner, Enter maxPlayerAge, "
					+ "Enter battingAvg, Enter wicketTaken");
		     
			 
			IPLTeam newIPLTeam=new IPLTeam(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextInt());
			System.out.println(iplTeamDao.signUpIPLTeam(newIPLTeam));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
