package hibernateDemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUserByPhno {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the phno to fetch the details");
		long phno=sc.nextLong();
		String qry="select u from User u where phno=:ph";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		q.setParameter("ph", phno);
		List<User> users=q.getResultList();
		if(users.size()>0) {
			for(User u:users) {
				System.out.println(u);
			}
		}else {
			System.err.println("Record not found");
		}
		
	}

}
