package hibernateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchPass {

	public static void main(String[] args) {
		String qry="select u.password from User u";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<String> q=s.createQuery(qry);
		List<String> pass=q.getResultList();
		for(String password:pass) {
			System.out.println(password);
		}
	}

}
