package org.jsp.UserApp.controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.UserApp.dto.Person;


public class FetchPersonByName {

	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		String qry="select p from Person p where p.name=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1, "Adam");
		List<Person> person=q.getResultList();
		
		for(Person p:person) {
		System.out.println(p.getName());
		}
		
	}

}
