package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.utils.HibernateUtil;
import static com.sunbeam.utils.HibernateUtil.getSessionFactory;

public class TesterHibernate {

	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory()) {
			System.out.println("Hibernate up n running !!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
