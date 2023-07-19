package org.jsp.Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.DTO.Person;

public class UpdatePerson {

	public static void main(String[] args) {
		Person p=new Person();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Id ");
		int id=sc.nextInt();
		System.out.println("Enter your name ");
		String name=sc.next();
		System.out.println("Enter your age ");
		int age=sc.nextInt();
		System.out.println("Enter your E-mail ");
		String email=sc.next();
		System.out.println("Enter your phone No ");
		Long phone=sc.nextLong();
		System.out.println("Enter your password ");
		String password=sc.next();
		p.setId(id);
		p.setAge(age);
		p.setName(name);
		p.setEmail(email);
		p.setPassword(password);
		p.setPhone(phone);
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
		EntityManager manager=factory.createEntityManager();
		manager.merge(p);
		EntityTransaction transaction=manager.getTransaction();
		transaction.begin();
		transaction.commit();
		System.out.println("Person saved with ID:"+p.getId());
		sc.close();

	}

}
