package org.jsp.UserApp.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jsp.UserApp.dto.UserApp;



public class UserDao {
	Session s=new Configuration().configure().buildSessionFactory().openSession();
	
	public UserApp saveUser(UserApp user) {
		Transaction t=s.beginTransaction();
		s.save(user);
		t.commit();
		return user;
	}
	public UserApp updateUser(UserApp user) {
		Transaction t=s.beginTransaction();
		s.update(user);
		t.commit();
		return user;
		
	}
	public UserApp FindUserById(int id) {
		
		return s.get(UserApp.class, id);
		
	}
	public boolean deleteUser(int id) {
		UserApp u=FindUserById(id);
		Transaction t=s.beginTransaction();
		if(u!=null) {
			s.delete(u);
			t.commit();
			return true;
		}return false;
		
	}
	public UserApp verifyUser(long phone, String password) {
	
		String hql="select u from UserApp u where u.phone=?1 and u.password=?2";
		Query<UserApp> q=s.createQuery(hql);
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return q.getSingleResult();
			
		}catch(NoResultException e) {
			System.err.println("NO record found");
			return null;
			
		}
		
	}
	public UserApp verifyUser(String email, String password) {
		
		String hql="select u from UserApp u where u.email=?1 and u.password=?2";
		Query<UserApp> q=s.createQuery(hql);
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			return q.getSingleResult();
			
		}catch(NoResultException e) {
			System.err.println("NO record found");
			return null;
			
		}
		
	}
public UserApp verifyUser(int id, String password) {
		
		String hql="select u from UserApp u where u.id=?1 and u.password=?2";
		Query<UserApp> q=s.createQuery(hql);
		q.setParameter(1, id);
		q.setParameter(2, password);
		try {
			return q.getSingleResult();
			
		}catch(NoResultException e) {
			System.err.println("NO record found");
			return null;
			
		}
		
	}


public void FetchAllUsers() {
	String hql="select u from UserApp u";
	Query<UserApp> q=s.createQuery(hql);
	List<UserApp> users=q.getResultList();
	System.out.println("id	name	gender	password	email		phone");
	System.out.println("--	-----   ------ ---------- 	-------    	 -------");
	for(UserApp u:users)
	{
		
		
		System.out.println(u.getId()+"	"+u.getName()+"	"+u.getGender()+"    "+u.getPassword()+" 	"+u.getEmail()+" 	 "+u.getPhone());
		
	}		
	
	
	
}

}
