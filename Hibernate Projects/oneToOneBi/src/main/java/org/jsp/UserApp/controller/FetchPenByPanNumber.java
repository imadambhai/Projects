package org.jsp.UserApp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.UserApp.dto.Card;

public class FetchPenByPanNumber {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the pan number");
		String pan = sc.next();

		String qry = "select c from Card c where c.number=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, pan);
		

		try {
			Card c = (Card) q.getSingleResult();
			System.out.println(c);
		} catch (NoResultException e) {
			System.err.println("No record found");
		}

	}

}
