package org.jsp.UserApp.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.UserApp.dto.Person;

public class FetchPersonByAge {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		String qry = "select p from Person p where p.age=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, 22);
		List<Person> per=q.getResultList();
		for(Person p:per) {
			System.out.println(p.getName());
		}
	}

}
