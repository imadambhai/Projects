package org.jsp.UserApp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.UserApp.dto.Person;

public class FetchPersonBtPanNumber {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the PAN number");
		String number = sc.next();

		String qry = "select c.p from Card c where c.number=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, number);
		Person p = (Person) q.getSingleResult();
		try {
			System.out.println(p);
		} catch (NoResultException e) {
		
		}

	}

}
