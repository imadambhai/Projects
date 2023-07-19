package org.jsp.UserApp.controller;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.UserApp.dto.Person;

public class FetchPersonByID {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

//		String qry="select p from Person p where p.id=?1";
//		Query q=manager.createQuery(qry);
//		q.setParameter(1, 1);
//		Person p=(Person) q.getSingleResult();

		Person p = manager.find(Person.class, 12);

		try {
			System.out.println(p.getName());
			System.out.println(p.getPhone());
		} catch (NullPointerException e) {
			System.err.println("No record found");
		}

	}

}
