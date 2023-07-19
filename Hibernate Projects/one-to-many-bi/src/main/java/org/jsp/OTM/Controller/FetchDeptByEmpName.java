package org.jsp.OTM.Controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class FetchDeptByEmpName {

	public static void main(String[] args) {

		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		String qry="select ";
	}

}
