package org.jsp.Controller;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.DTO.Person;

public class FetchPersonById {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Id to display details");
		int id=sc.nextInt();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Person p=manager.find(Person.class, id);
		if(p!=null) {
			System.out.println("id: "+p.getId());
			System.out.println("Name:"+p.getName());
			System.out.println("Age: "+p.getAge());
			System.out.println("Phone: "+p.getPhone());
			System.out.println("E-mail: "+p.getEmail());
			System.out.println("Password: "+p.getPassword());
		}else {
			System.err.println("No record found");
		}
	}

}
