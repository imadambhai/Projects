package org.jsp.Controller;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.jsp.DTO.Person;
public class removePerson {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your id to remove");
		int id=sc.nextInt();
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		Person p=manager.find(Person.class, id);
		
		if(p!=null) {
			manager.remove(p);
			EntityTransaction t=manager.getTransaction();
			t.begin();
			t.commit();
			System.out.println("Id deleted successfully");
		}else {
			System.err.println("Enter id in invalid");
		}
	}

}
