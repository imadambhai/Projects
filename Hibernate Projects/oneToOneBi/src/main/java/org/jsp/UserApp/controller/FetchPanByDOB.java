package org.jsp.UserApp.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.UserApp.dto.Card;

public class FetchPanByDOB {

	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the DOB (YYYY-MM-DD)");
		LocalDate date=LocalDate.parse(sc.next());
		
		String qry="select c from Card c where c.DOB=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1, date);
		List<Card> cards=q.getResultList();
		if(cards!=null) {
			for (Card c : cards) {
				System.out.println(c);
				
			}
		}
		
	}

}
