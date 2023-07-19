package hibernateDemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class updateUser {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your UserId to update the Details:");
		int uid=sc.nextInt();
		System.out.println("Enter the name,password and phono No");
		String name=sc.next();
		String pass=sc.next();
		long phone=sc.nextLong();
		User u=new User();
		u.setId(uid);
		u.setName(name);
		u.setPassword(pass);
		u.setPhno(phone);
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Transaction t=s.beginTransaction();
		s.update(u);
		t.commit();
	}

}
