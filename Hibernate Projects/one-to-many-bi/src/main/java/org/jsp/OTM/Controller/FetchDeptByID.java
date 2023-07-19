package org.jsp.OTM.Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.OTM.DTO.Department;

public class FetchDeptByID {

	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		
		Department d=manager.find(Department.class, 1);
		System.out.println(d.getId());
		System.out.println(d.getName());
		System.out.println(d.getLoc());
		
	}

}
