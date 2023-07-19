package hibernateDemo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUserByID {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your Id to display the details");
		int eid=sc.nextInt();
		String hql="select u from User u where u.id=?1";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(hql);
		q.setParameter(1, eid);
		try {
			User u=q.getSingleResult();
			System.out.println(u);
		}catch(NoResultException e){
			System.err.println("Invalid ID");
		}

	}

}
