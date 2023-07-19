package org.jsp.UserApp.controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import org.jsp.UserApp.dto.Card;

public class FetchPanByID {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Id");
		int id = sc.nextInt();

		Card c = manager.find(Card.class, id);

		try {
			System.out.println(c);
		} catch (NoResultException e) {
			System.err.println("No record found");
		}
	}

}
