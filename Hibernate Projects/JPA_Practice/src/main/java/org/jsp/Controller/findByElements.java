package org.jsp.Controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.DTO.Person;

public class findByElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Find by age");
		System.out.println("2. Find by phone no");
		System.out.println("3. Find by Email");
		System.out.println("4. Find by Name");
		System.out.println("5. Show all the Names from the Database");
		System.out.println("6. Fetch All age by using ID");
		System.out.println("7. fetch all Id by using name");
		System.out.println("8. Fetch all phone by using name");
		
		
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			findByAge();
			break;
		}
		case 2:{
			findByPhone();
			break;
		}
		case 3:{
			findByEmail();
			break;
		}
		case 4:{
			findByName();
			break;
		}
		case 5:{
			FetchAllNames();
			break;
		}
		case 6:{
			FetchAllAgeById();
			break;
		}

		}

	}

	private static void FetchAllAgeById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Id");
		int id = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createNamedQuery("fetchAllAgeById");
		q.setParameter(1, id);
		List<Integer> persons = q.getResultList();
		for (Integer p : persons) {
			System.out.println("Age is "+p);

		}
		
		
	}

	private static void FetchAllNames() {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createNamedQuery("fetchAllPersons");
//		q.setParameter(1, name);
		List<String> persons = q.getResultList();
		for (String p : persons) {
			System.out.println(p);

		}
		
	}

	private static void findByName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Name");
		String name = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createNamedQuery("findByName");
		q.setParameter(1, name);
		List<Person> persons = q.getResultList();
		for (Person p : persons) {
			System.out.println(p);

		}
		
	}

	private static void findByEmail() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the E-mail");
		String email = sc.next();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createNamedQuery("findByEmail");
		q.setParameter(1, email);
		List<Person> persons = q.getResultList();
		for (Person p : persons) {
			System.out.println(p);

		}
		
	}

	private static void findByPhone() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the phone");
		long phone = sc.nextLong();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createNamedQuery("findByPhone");
		q.setParameter(1, phone);
		List<Person> persons = q.getResultList();
		for (Person p : persons) {
			System.out.println(p);

		}
		
	}

	private static void findByAge() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the age");
		int age = sc.nextInt();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Query q = manager.createNamedQuery("findByAge");
		q.setParameter(1, age);
		List<Person> persons = q.getResultList();
		for (Person p : persons) {
			System.out.println(p);

		}

	}

}
