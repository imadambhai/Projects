package hibernateDemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchIdByPhno {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Ph no to fetch the ID");
		long phno=sc.nextLong();
		
		String qry="select u.id from User u where u.phno=?1";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<Integer> q=s.createQuery(qry);
		q.setParameter(1, phno);
		
		List<Integer> ids=q.getResultList();
		if(ids.size()>0) {
			for(Integer id:ids) {
				System.out.println(id);
			}
		}else {
			System.err.println("No record found");
		}
	}

}
