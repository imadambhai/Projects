package org.jsp.UserApp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.UserApp.dto.Person;

public class FetchPersonByPhone {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the phone number");
		long phone = sc.nextLong();

		String qry = "select p from Person p where p.phone=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		Person p = (Person) q.getSingleResult();
		try {
			System.out.println(p);
		} catch (NoResultException e) {
			System.err.println("No record found");
		}

	}

}
