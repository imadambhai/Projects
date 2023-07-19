package org.jsp.MTM.DTO;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchBatchByPhoneAndPerc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Student phone and perc");
		long phone = sc.nextLong();
		double perc = sc.nextDouble();
		EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

		String qry = "select s.batches from Student s where s.phone=?1 and s.perc=?2";
		Query q = manager.createQuery(qry);
		q.setParameter(1, phone);
		q.setParameter(2, perc);
		Batch b = (Batch) q.getSingleResult();
		try {
			System.out.println(b);
		} catch (NoResultException e) {
			System.err.println("No record found");
		}

	}

}
