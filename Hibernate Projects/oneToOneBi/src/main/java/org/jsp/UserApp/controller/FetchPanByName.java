package org.jsp.UserApp.controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.UserApp.dto.Card;

public class FetchPanByName {

	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name");
		String name=sc.next();
		
		String qry="select p.card from Person p where p.name=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1, name);
		List<Card> cards=q.getResultList();
		if(cards!=null) {
			for (Card c : cards) {
				System.out.println(c);
				
			}
		}
	}

}
