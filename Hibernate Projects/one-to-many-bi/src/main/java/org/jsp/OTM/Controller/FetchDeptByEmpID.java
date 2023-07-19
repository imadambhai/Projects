package org.jsp.OTM.Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.OTM.DTO.Department;
import org.jsp.OTM.DTO.Employee;

public class FetchDeptByEmpID {
public static void main(String[] args) {
	EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	
//	String qry="select d from Department d where d.e.id=?1";
//	String qr1="select d.e from Deparatment d where e.id=?1";
	
	String qry="select e.dept from Employee e where e.id=?1";
	
	Query q=manager.createQuery(qry);
	q.setParameter(1, 1);
	Department d=(Department) q.getSingleResult();
	
//	Employee e=manager.find(Employee.class, 1);
//	Department d=e.getDept();
	
	System.out.println(d.getId());
	System.out.println(d.getLoc());
	System.out.println(d.getName());
}
}
