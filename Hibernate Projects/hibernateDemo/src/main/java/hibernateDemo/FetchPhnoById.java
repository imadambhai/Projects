package hibernateDemo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchPhnoById {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Id to fetch the details");
		int uid=sc.nextInt();
		
		String qry="select u.phno from User u where id=?1";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<Long> q=s.createQuery(qry);
		q.setParameter(1, uid);
		
		try {
			Long u=q.getSingleResult();
			System.out.println(u);
		}catch(NoResultException e) {
			System.err.println("No record found");
		}
		
	}

}
