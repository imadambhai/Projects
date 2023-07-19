package hibernateDemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchAllUser {

	public static void main(String[] args) {
		String hql="select u from User u";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(hql);
		List<User> users=q.getResultList();
		for(User u:users)
		{
			//By using toString method
			//System.out.println(u.toString());
			
			//By using own printing statement
			
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("Id:"+u.getId());
			System.out.println("Name:"+u.getName());
			System.out.println("PhoneNo:"+u.getPhno());
			System.out.println("Password:"+u.getPassword());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
		}

	}

}
