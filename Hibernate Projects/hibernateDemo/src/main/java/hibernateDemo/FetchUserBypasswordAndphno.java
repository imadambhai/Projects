package hibernateDemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUserBypasswordAndphno {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the password and phno to display the details");
		String pass=sc.nextLine();
		long phno=sc.nextLong();
		String qry="select u from User u where u.password=?1 and u.phno=?2";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		q.setParameter(1, pass);
		q.setParameter(2, phno);
		List<User> users=q.getResultList();
		if(users.size()>0) {
			for(User u:users) {
				System.out.println(u);
			}
		}else {
			System.err.println("No user found");
		}
	}

}
