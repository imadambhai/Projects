package org.jsp.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.DTO.FoodOrder;
import org.jsp.DTO.User;

public class FoodDao {
	static EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	static EntityTransaction t = manager.getTransaction();

	public FoodOrder findById(int fid) {
		return manager.find(FoodOrder.class, fid);
	}

	public FoodOrder verifyByEmailAndPass(String email, String pass) {
		String qry = "select u.food from User u where u.email=?1 and u.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, email);
		q.setParameter(2, pass);
		List<FoodOrder> foods = q.getResultList();
		if (foods != null) {
			for (FoodOrder f : foods) {
				System.out.println(f);

			}
		}

		return null;
	}

	public void deleteFood(FoodOrder f) {
		manager.remove(f);
		t.begin();
		t.commit();

	}

	public User findByPhoneByPass(long phone, String pass) {
		String qry = "select u from User u where u.phone=?1 and u.password=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, pass);
		User u = (User) q.getSingleResult();

		return u;
	}

	public List<FoodOrder> FetchByUserName(String name) {
		String qry="select u.food from User u where u.name=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1, name);
		List<FoodOrder> fds=q.getResultList();
		if(fds!=null)
			return fds;

		
		return null;
	}

	public List<FoodOrder> FetchByFoodName(String fname) {
		String qry="select f from FoodOrder f where f.itemname=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1, fname);
		List<FoodOrder> fds=q.getResultList();
		if(fds!=null)
			return fds;
		
		
		return null;
	}

}
