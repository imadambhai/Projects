package org.jsp.Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.DTO.Person;

public class findPerson {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your id");
		int id=sc.nextInt();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Person p=manager.find(Person.class, id);
		EntityTransaction t=manager.getTransaction();
		t.begin();
		t.commit();
		if(p!=null) {
			System.out.println("done");
			
		}else
		{
			System.err.println("Record not found");
			
		}
	}

}
