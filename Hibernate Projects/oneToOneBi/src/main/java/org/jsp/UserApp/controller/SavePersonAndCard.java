package org.jsp.UserApp.controller;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.UserApp.dto.Card;
import org.jsp.UserApp.dto.Person;

public class SavePersonAndCard {

	public static void main(String[] args) {
		Person p=new Person();
		p.setName("Adam");
		p.setAge(22);
		p.setPhone(3213224);
		Card card=new Card();
		card.setDOB(LocalDate.parse("2022-09-19"));
		card.setNumber("afdsf545435");
		card.setPincode(631102);
		p.setCard(card);
		
//		card.setP(p);
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		manager.persist(p);
		transaction.begin();
		transaction.commit();
		
	}

}
