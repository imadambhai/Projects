package hibernateDemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUserByPass {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the password to fetch the details");
		String pass=sc.nextLine();
		String qry="select u from User u where u.password=?1";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(qry);
		q.setParameter(1, pass);
		List<User> users=q.getResultList();
		if(users.size()>0) {
			for(User u:users) {
				System.out.println(u);
			}
		}else {
			System.err.println("No record found");
		}
	}

}
