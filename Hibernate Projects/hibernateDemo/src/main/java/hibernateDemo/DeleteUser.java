package hibernateDemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteUser {

	public static void main(String[] args) {
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Transaction t=s.beginTransaction();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee ID to delete");
		int eid=sc.nextInt();
		User u=s.get(User.class, eid);
		if(u!=null) {
			s.delete(u);
			System.out.println("Record deleted successfully");
			t.commit();
		}
			else {
				System.err.println("Invalid ID");
			}
		}
		
		
		
	
}
