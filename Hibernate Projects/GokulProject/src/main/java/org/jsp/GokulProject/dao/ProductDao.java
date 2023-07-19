package org.jsp.GokulProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.GokulProject.dto.Product;
import org.jsp.GokulProject.dto.User;

public class ProductDao {
	EntityManager m=Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction t=m.getTransaction();
	public Product saveProduct(Product p) {
		m.persist(p);
		t.begin();
		t.commit();
		return p;
	}
	public void findPid(int uid) {
		User u=m.find(User.class, uid);
		List<Product> p=u.getProd();
		if(u!=null) {
		for(Product prod:p) {
			System.out.println(prod);
		}
		}
		else {
			System.out.println("Invalid Brand");
		}
	}
	public void prodByBrand(String brand) {
		String qry="select p from Product p where p.brand=?1";
		Query q=m.createQuery(qry);
		q.setParameter(1, brand);
		List<Product> p=q.getResultList();
		for(Product prod:p) {
			System.out.println(prod);
		}
	}
	public void prodByCat(String category) {
		String qry="select p from Product p where p.category=?1";
		Query q=m.createQuery(qry);
		q.setParameter(1, category);
		List<Product> p=q.getResultList();
		for(Product prod:p) {
			System.out.println(prod);
		}
	}
	public void deleteProd(int pid) {
		Product p= m.find(Product.class, pid);
		if(p!=null) {
			m.remove(p);
			t.begin();
			t.commit();
		}
	}

}
