package org.jsp.Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.DTO.Department;
import org.jsp.DTO.Employee;

public class control {
	static EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	static EntityTransaction transaction = manager.getTransaction();

	public void save(Department d) {
		manager.persist(d);
		transaction.begin();
		transaction.commit();

	}

	public Department fetch(int id) {
		return manager.find(Department.class, id);
	}

	public void update(Department d) {

		manager.merge(d);
		transaction.begin();
		transaction.commit();
	}

	public void FetchByName(String name) {
		String qry = "select d.emp from Department d where d.dname=?1";
		System.out.println("method runnig");
		Query query = manager.createQuery(qry);
		query.setParameter(1, name);
		System.out.println("Query runnig");
		List<Employee> emps = query.getResultList();
		System.out.println("method finish");

		if (emps.size() > 0) {
			for (Employee e : emps) {
				System.out.println(e.getName());

			}
		} else {
			System.err.println("Record not found");
		}

	}

	public Employee findEmp(int id) {

		return manager.find(Employee.class, id);
	}

	public void deleteEmp(Employee e2) {
		Employee e = manager.find(Employee.class, e2);
		if (e != null) {
//		System.out.println(e.getName());
			manager.remove(e);
			transaction.begin();
			transaction.commit();
		}
	}

}
