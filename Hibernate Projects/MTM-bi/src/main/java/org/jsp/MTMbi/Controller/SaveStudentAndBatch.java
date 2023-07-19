package org.jsp.MTMbi.Controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Transaction;
import org.jsp.MTMbi.DTO.Batch;
import org.jsp.MTMbi.DTO.Student;

public class SaveStudentAndBatch {

	public static void main(String[] args) {
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
		Batch b1 = new Batch();
		b1.setSubject("Hibernate");
		b1.setCode("SHES1");

		Batch b2 = new Batch();
		b2.setSubject("Spring");
		b2.setCode("SHES2");

		Batch b3 = new Batch();
		b3.setSubject("J2EE");
		b3.setCode("SHES3");

		Student s1 = new Student();
		s1.setName("Gokul");
		s1.setPerc(72);
		s1.setPhone(84454);

		Student s2 = new Student();
		s2.setName("Vicky");
		s2.setPerc(92);
		s2.setPhone(84484);

		Student s3 = new Student();
		s3.setName("Adam");
		s3.setPerc(72);
		s3.setPhone(84554);
		
		b1.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
		b2.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
		b3.setStudents(new ArrayList<Student>(Arrays.asList(s1,s2,s3)));
		manager.persist(b1);
		manager.persist(b2);
		manager.persist(b3);
		
		EntityTransaction t=manager.getTransaction();
		t.begin();
		t.commit();

	}

}
