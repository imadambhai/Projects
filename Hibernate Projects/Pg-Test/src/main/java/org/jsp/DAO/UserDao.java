package org.jsp.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.DTO.User;

public class UserDao {
	static EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	static EntityTransaction t = manager.getTransaction();

	public void saveUser(User u) {
		manager.persist(u);
		t.begin();
		t.commit();

	}

	public User VerifyByMailAndPass(String email, String pass) {
		String qry = "select u from User u where u.email=?1 and u.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, email);
		q.setParameter(2, pass);
		User u = (User) q.getSingleResult();

		return u;
	}

	public User findById(int uid) {

		return manager.find(User.class, uid);
	}

	public void saveFood(User u) {
		manager.persist(u);
		t.begin();
		t.commit();
	}

	public void saveUpdate(User u) {

		manager.merge(u);
		t.begin();
		t.commit();

	}

}
