package hibernateDemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FetchUser {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Id to fetch the details");
		int id=sc.nextInt();
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		User u=s.get(User.class, id);
		if(u!=null)
		{
			System.out.println("id: "+u.getId());
			System.out.println("Name: "+u.getName());
			System.out.println("password: "+u.getPassword());
			System.out.println("phone No: "+u.getPhno());
		}
				
	
	}

}
