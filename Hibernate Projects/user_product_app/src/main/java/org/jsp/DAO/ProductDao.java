package org.jsp.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Transaction;
import org.jsp.DTO.Product;
import org.jsp.DTO.User;

public class ProductDao {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction t = manager.getTransaction();

	public Product saveProd(Product p) {

		manager.persist(p);
		t.begin();
		t.commit();

		return null;
	}

	public void FetchByUserId(int uid) {
		String qry = "select u.products from User u where u.id=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, uid);
		List<Product> prds = q.getResultList();
		if (prds != null) {
			for (Product p : prds) {

				System.out.println(p);
			}
		} else {
			System.err.println("You don't have any products");
		}

	}

	public void FetchByCat(String cat) {
		String qry = "select p from Product p where p.category=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, cat);
		List<Product> prds = q.getResultList();
		if (prds != null) {
			for (Product p : prds) {

				System.out.println(p);
			}
		} else {
			System.err.println("You don't have any products in this category");
		}

	}

	public void FetchByBrand(String brand) {
		String qry = "select p from Product p where p.brand=?1";
		Query q = manager.createQuery(qry);
		q.setParameter(1, brand);
		List<Product> prds = q.getResultList();
		if (prds != null) {
			for (Product p : prds) {

				System.out.println(p);
			}
		} else {
			System.err.println("You don't have any products in this Brand");
		}

	}

	public Product findById(int pid) {
		return manager.find(Product.class, pid);
	}

	public void delete(Product p) {
		manager.remove(p);
		t.begin();
		t.commit();
	}

	public void fetchByUserIdByFind(int uid) {
		User u = manager.find(User.class, uid);
		List<Product> p = u.getProducts();
		for (Product product : p) {
			System.out.println(product);

		}
	}

	public void FetchByPhoneAndPass(long phone, String pass) {
		String qry = "select u.products from User u where u.phone=?1 and u.pasword=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, pass);
		List<Product> prds = q.getResultList();
		if (prds != null) {
			for (Product p : prds) {

				System.out.println(p);
			}
		} else {
			System.err.println("You don't have any products");
		}

	}

	public void updateProd(Product p) {
		manager.merge(p);
		t.begin();
		t.commit();
	}

}
