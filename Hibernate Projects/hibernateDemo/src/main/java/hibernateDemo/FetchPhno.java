package hibernateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchPhno {

	public static void main(String[] args) {
		String qry="select u.phno from User u";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<Long> q=s.createQuery(qry);
		List<Long> phnos=q.getResultList();
		for(Long phno:phnos) {
			System.out.println(phno);
			
		}
	}

}
