package hibernateDemo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchUserByName {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the name to fetch the all the details");
		String name=sc.next();
		String hql="select u from User u where u.name=:nm";
		Session s=new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q=s.createQuery(hql);
		q.setParameter("nm", name);
		List<User> users=q.getResultList();
		if(users.size()>0)
		{
			for(User u:users) {
			System.out.println("Id:"+u.getId());
			System.out.println("Name:"+u.getName());
			System.out.println("PhoneNo:"+u.getPhno());
			System.out.println("Password:"+u.getPassword());
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			}
		}else {
			System.err.println("Record not found");
		}
	}

}
