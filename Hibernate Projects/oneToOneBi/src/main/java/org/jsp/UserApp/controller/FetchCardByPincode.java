package org.jsp.UserApp.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.UserApp.dto.Card;

public class FetchCardByPincode {

	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the pincode");
		long pin=sc.nextLong();
		
		String qry="select c from Card c where c.pincode=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1, pin);
		List<Card> cards=q.getResultList();
		if(cards!=null) {
			for (Card c : cards) {
				System.out.println(c);
				
			}
		}
	}

}
