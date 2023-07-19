package hibernateDemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUserByIdAndName {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Id and name to fetch the details");
		int uid=sc.nextInt();
		String uname=sc.next();
		
		String qry="select u from User u where u.id=?1 and u.name=:nm";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		q.setParameter(1, uid);
		q.setParameter("nm", uname);
		List<User> users=q.getResultList();
		if(users.size()>0) {
			for(User u:users) {
				System.out.println(u);
			}
		}else {
			System.err.println("record not found");
		}
		
	}

}
