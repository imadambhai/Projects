package org.jsp.OTM.Controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.jsp.OTM.DTO.Department;
import org.jsp.OTM.DTO.Employee;

public class SaveEmpAndDept {

	public static void main(String[] args) {
		EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		Department d=new Department();
		d.setName("Developer");
		d.setLoc("Chennai");
		
		Employee e1=new Employee();
		e1.setName("Adam");
		e1.setDesg("Trainee Associate");
		e1.setSal(20000);
		e1.setDept(d);
		
		Employee e2=new Employee();
		e2.setName("Gokul");
		e2.setDesg("Trainee Associate");
		e2.setSal(30000);
		e2.setDept(d);
		
		Employee e3=new Employee();
		e3.setName("Vicky");
		e3.setDesg("Trainee Associate");
		e3.setSal(25000);
		e3.setDept(d);
		
		d.setEmp(new ArrayList<Employee>(Arrays.asList(e1,e2,e3)));
		manager.persist(d);
		transaction.begin();
		transaction.commit();
		
	}

}
