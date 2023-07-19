package org.jsp.OTM.Controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.OTM.DTO.Department;

public class FetchDeptByDeptName {

	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry="select d from Department d where d.name=?1";
		
		Query q=manager.createQuery(qry);
		q.setParameter(1, "Developer");
		Department d=(Department) q.getSingleResult();
		
		System.out.println(d.getId());
		System.out.println(d.getLoc());
		System.out.println(d.getName());
		
	}

}
