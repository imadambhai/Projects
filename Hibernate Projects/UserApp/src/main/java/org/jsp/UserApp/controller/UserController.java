package org.jsp.UserApp.controller;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.jsp.UserApp.dao.UserDao;
import org.jsp.UserApp.dto.UserApp;

public class UserController {
	static Scanner sc = new Scanner(System.in);
	static UserDao dao = new UserDao();

	Session s = new Configuration().configure().buildSessionFactory().openSession();
	//Transaction t = s.beginTransaction();

	public static void main(String[] args) {
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("1. Register User");
		System.out.println("2. Edit your Details");
		System.out.println("3. Find User by ID");
		System.out.println("4. Delete user by Id");
		System.out.println("5. Verify user by phone and password");
		System.out.println("6. verify user by email and password");
		System.out.println("7. Verify user by id and password");
		System.out.println("8. Show all the Users");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		switch (choice) {
		case 1: {
			save();
			break;
		}

		case 2: {
			update();
			break;
		}

		case 3: {
			find();
			break;

		}

		case 4: {
			delete();
			break;
		}
		case 5: {
			fetchUserByPhAndPass();
			break;
		}
		case 6: {
			fetchUserByMailAndPass();
			break;
		}
		case 7: {
			fetchUserByidAndPass();
			break;
		}
		case 8: {
			FetchAllUsers();
			break;
		}
		}
		main(args);

	}
	

	private static void FetchAllUsers() {
		// TODO Auto-generated method stub
		dao.FetchAllUsers();

	}

	private static void fetchUserByidAndPass() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Id and password to fetch the user");
		System.out.println();
		int id = sc.nextInt();
		String pass = sc.next();
		UserApp u = new UserApp();
		u = dao.verifyUser(id, pass);
		if (u != null) {
			System.out.println("id: " + u.getId());
			System.out.println("Name: " + u.getName());
			System.out.println("password: " + u.getPassword());
			System.out.println("phone No: " + u.getPhone());
		}

	}

	private static void fetchUserByMailAndPass() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Mail and password to fetch the user");
		String email = sc.next();
		String pass = sc.next();
		UserApp u = new UserApp();
		u = dao.verifyUser(email, pass);
		if (u != null) {
			System.out.println("id: " + u.getId());
			System.out.println("Name: " + u.getName());
			System.out.println("password: " + u.getPassword());
			System.out.println("phone No: " + u.getPhone());
		}

	}

	private static void fetchUserByPhAndPass() {
		// TODO Auto-generated method stub
		System.out.println("Enter the phone and password to fetch the user");
		long phone = sc.nextLong();
		String pass = sc.next();
		UserApp u = new UserApp();
		u = dao.verifyUser(phone, pass);
		if (u != null) {
			System.out.println("id: " + u.getId());
			System.out.println("Name: " + u.getName());
			System.out.println("password: " + u.getPassword());
			System.out.println("phone No: " + u.getPhone());
		} else {
			System.err.println("No record found");
		}

	}

	private static void find() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Id to find the user");
		int id = sc.nextInt();
		UserApp u = new UserApp();
		u = dao.FindUserById(id);
		if (u != null) {
			System.out.println("id: " + u.getId());
			System.out.println("Name: " + u.getName());
			System.out.println("password: " + u.getPassword());
			System.out.println("phone No: " + u.getPhone());
		} else {
			System.err.println("No record found");
		}
	}

	private static void delete() {
		// TODO Auto-generated method stub
		System.out.println("Enter the Id to delete");
		int id = sc.nextInt();
		boolean u = dao.deleteUser(id);
		if (u != false) {
			System.out.println("Your record is deleted");
		} else {
			System.err.println("Enter id is invalid");
		}

	}

	public static void update() {
		// TODO Auto-generated method stub
		System.out.println("Enter your Id to update details");
		int id = sc.nextInt();
		System.out.println("Enter your name");
		String name = sc.next();
		System.out.println("Enter your E-mail");
		String email = sc.next();
		System.out.println("Enter your Gender");
		String gender = sc.next();
		System.out.println("Enter your Phone No");
		long phone = sc.nextLong();
		System.out.println("Enter your Password");
		String password = sc.next();
		UserApp u = new UserApp();
		u.setId(id);
		u.setName(name);
		u.setGender(gender);
		u.setEmail(email);
		u.setPassword(password);
		u.setPhone(phone);
		u = dao.updateUser(u);
		System.out.println("Your accound is updated");

	}

	private static void save() {
		// TODO Auto-generated method stub
		System.out.println("Enter your Name");
		String name = sc.next();
		System.out.println("Enter your E-mail");
		String email = sc.next();
		System.out.println("Enter your Gender");
		String gender = sc.next();
		System.out.println("Enter your Phone");
		long phone = sc.nextLong();
		System.out.println("Enter your Create Password");
		String password = sc.next();
		UserApp u = new UserApp();
		u.setName(name);
		u.setGender(gender);
		u.setEmail(email);
		u.setPassword(password);
		u.setPhone(phone);
		u = dao.saveUser(u);
		System.out.println("You are register with Id " + u.getId());

	}

}
