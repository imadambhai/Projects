package hibernateDemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class saveUser {

	public static void main(String[] args) {
		User u=new User();
		System.out.println("Enter the details");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Name");
		
		String name=sc.next();
		System.out.println("Enter the phno");
		long phno=sc.nextLong();
		System.out.println("Enter the password");
		String pass=sc.next();
		
		
		u.setName(name);
		u.setPhno(phno);
		u.setPassword(pass);
		
		Configuration cfg=new Configuration().configure();
		SessionFactory factory=cfg.buildSessionFactory();
		Session s=factory.openSession();
		s.save(u);
		System.out.println("Record saved with id:"+u.getId());
		Transaction t=s.beginTransaction();
		t.commit();
		s.close();
		factory.close();

}

}
