package org.jsp.OTM.Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.OTM.DTO.Department;

public class FetchDeptByLoc {
	public static void main(String[] args) {

		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry="select d from Department d where d.loc=?1";
		Query q=manager.createQuery(qry);
		q.setParameter(1, "chennai");
		
		List<Department> dept=q.getResultList();
		if(dept!=null) {
			for (Department d : dept) {
				System.out.println(d);
				
			}
		}
	}

}
