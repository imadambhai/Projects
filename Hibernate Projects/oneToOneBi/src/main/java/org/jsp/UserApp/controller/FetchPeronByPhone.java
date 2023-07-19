package org.jsp.UserApp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.UserApp.dto.Person;

public class FetchPeronByPhone {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the phone");
		long phone=sc.nextLong();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry="select p from Person p where p.phone=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1, phone);
		Person p=(Person) q.getSingleResult();
		try {
			System.out.println(p);
		} catch (NoResultException e) {
			System.err.println("No record found");
		}
		
		}

}
