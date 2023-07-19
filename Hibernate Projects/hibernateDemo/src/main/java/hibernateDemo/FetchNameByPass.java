package hibernateDemo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchNameByPass {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the pass to fetch the details");
		String pass=sc.nextLine();
		
		String qry="select u.name from User u where password=?1";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<String> q=s.createQuery(qry);
		q.setParameter(1, pass);
		List<String> names=q.getResultList();
		if(names.size()>0) {
			for(String name:names) {
				System.out.println(name);
			}
		}else {
			System.err.println("Record not found");
		}
		
//		try {
//			String u=q.getSingleResult();
//			System.out.println(u);
//		}catch(NoResultException e) {
//			System.err.println("Record not found");
//		}
		
		
	}

}
