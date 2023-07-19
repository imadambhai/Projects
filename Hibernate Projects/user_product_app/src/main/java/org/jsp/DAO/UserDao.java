package org.jsp.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.DTO.User;

public class UserDao {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction t = manager.getTransaction();

	public void saveUser(User u) {
		manager.persist(u);
		t.begin();
		t.commit();

	}

	public User findId(int id) {

		return manager.find(User.class, id);
	}

	public void updateUser(User u) {
		manager.merge(u);
		t.begin();
		t.commit();

	}

	public User fetchByPhone(long phone, String pass) {
		String qry = "select u from User u where u.phone=?1 and u.pasword=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, pass);
		User u = (User) q.getSingleResult();
		if (u != null) {
			return u;
		} else {
			return null;
		}

	}

	public User fetchByEmail(String email, String pass) {
		String qry = "select u from User u where u.email=?1 and u.pasword=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, email);
		q.setParameter(2, pass);
		User u = (User) q.getSingleResult();
		if (u != null) {
			return u;
		} else {
			return null;
		}

	}

	public void deleteUser(User u) {
		manager.remove(u);
		t.begin();
		t.commit();

	}

}
