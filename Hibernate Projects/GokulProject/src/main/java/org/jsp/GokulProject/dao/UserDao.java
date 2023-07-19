package org.jsp.GokulProject.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.GokulProject.dto.User;

public class UserDao {
EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();
EntityTransaction t=m.getTransaction();
public User saveUser(User u) {
	m.persist(u);
	t.begin();
	t.commit();
	return u;
}
public User findById(int id) {
	
	return m.find(User.class, id);
}
public User updateUser(User u) {
	m.merge(u);
	t.begin();
	t.commit();
	return u;
}
public User verifyByPhone(long phone, String password) {
	String qry="select u from User u where u.phone=?1 and password=?2";
	Query q=m.createQuery(qry);
	q.setParameter(1, phone);
	q.setParameter(2, password);
	User u=(User)q.getSingleResult();
	return u;
}
public User verifyByEmail(String email, String password) {
	String qry="select u from User u where u.email=?1 and password=?2";
	Query q=m.createQuery(qry);
	q.setParameter(1, email);
	q.setParameter(2, password);
	User u=(User)q.getSingleResult();
	return u;
}

}
