package org.jsp.UserApp.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.UserApp.dto.Card;
import org.jsp.UserApp.dto.Person;

public class FetchPanByPersonID {
	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
//		String qry = "select c from Card c where p.id=?1";
//		Query q = manager.createQuery(qry);
//		q.setParameter(1, 1);
//		Card c=(Card) q.getSingleResult();
		
		Person p=manager.find(Person.class, 1);
		
		if(p!=null) {
			Card c=p.getCard();
			System.out.println(c);
		}
		
		
	}
	

}
