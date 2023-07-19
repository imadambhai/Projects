package org.jsp.UserApp.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.UserApp.dto.Card;
import org.jsp.UserApp.dto.Person;

public class FetchPersonByPanID {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

//		String qry = "select p from Person p where p.card.id=?1";
//		Query q = manager.createQuery(qry);
//		q.setParameter(1, 1);
//		Person p=(Person) q.getSingleResult();
		
		Card c=manager.find(Card.class, 1);
		Person p=c.getP();
		if(c!=null) {
			
			System.out.println(p.getName());
		}
		
	}

}
