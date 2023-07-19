package org.jsp.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.jsp.DAO.ProductDao;
import org.jsp.DAO.UserDao;
import org.jsp.DTO.Product;
import org.jsp.DTO.User;

public class controller {
	static Scanner sc = new Scanner(System.in);
	static UserDao uDao = new UserDao();
	static ProductDao pDao = new ProductDao();
	static User u = new User();
	static Product p = new Product();

	public static void main(String[] args) {
		System.out.println("1. Register User");
		System.out.println("2. Update User");
		System.out.println("3. Verify User by phone and password");
		System.out.println("4. verify user by email and password");
		System.out.println("5. Add product");
		System.out.println("6. View products by user Id");
		System.out.println("7. View products by category");
		System.out.println("8. View products by brand");
		System.out.println("9. Delete product");
		System.out.println("10.Fetch products by using phone and password");
		System.out.println("11.Update product");
		System.out.println("12.Delete User");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			saveUser();
			break;
		case 2:
			updateUser();
			break;
		case 3:
			userByPhone();
			break;
		case 4:
			userByEmail();
			break;
		case 5:
			saveProd();
			break;
		case 6:
			ViewByUserId();
			break;
		case 7:
			ViewByCat();
			break;
		case 8:
			ViewByBrand();
			break;
		case 9:
			deleteProd();
			break;
		case 10:
			viewByPhoneAndPass();
			break;
		case 11:
			updateProd();
			break;
		case 12:
			deleteUser();
			break;
		case 13:
			viewByPhoneAndPass();
			break;
		default:
			break;
		}
	}

	private static void deleteUser() {
		System.out.println("Enter the user ID");
		int uid=sc.nextInt();
		u=uDao.findId(uid);
		if(u!=null) {
			uDao.deleteUser(u);
			
		}
		
		
	}

	private static void updateProd() {
		System.out.println("Enter the UserId to update the products");
		int uid=sc.nextInt();
		System.out.println("Enter the product Id to update");
		int pid=sc.nextInt();
		u=uDao.findId(uid);
		if(u!=null) {
			System.out.println("Enter the product Name");
			String pname = sc.next();
			System.out.println("Enter the product Category");
			String cat = sc.next();
			System.out.println("Enter the product Brand");
			String brand = sc.next();
			System.out.println("Enter the product Price");
			Double price = sc.nextDouble();
			p.setId(pid);
			p.setPname(pname);
			p.setBrand(brand);
			p.setCategory(cat);
			p.setPrice(price);
			p.setUser(u);
//			u.setProducts(new ArrayList<Product>(Arrays.asList(p)));
			pDao.updateProd(p);
			System.out.println("Your products are updated");
		}
		
		
	}

	private static void viewByPhoneAndPass() {
		System.out.println("Enter the phone");
		long phone=sc.nextLong();
		System.out.println("Enter the password");
		String pass=sc.next();
		pDao.FetchByPhoneAndPass(phone,pass);
		
		
	}

	private static void deleteProd() {
		System.out.println("Enter the Product Id to delete");
		int pid = sc.nextInt();
		p = pDao.findById(pid);
		if (p != null) {
			pDao.delete(p);
		}

	}

	private static void ViewByBrand() {
		System.out.println("Enter the Brand");
		String brand = sc.next();
		pDao.FetchByBrand(brand);

	}

	private static void ViewByCat() {
		System.out.println("Enter the Category");
		String cat = sc.next();
		pDao.FetchByCat(cat);

	}

	private static void ViewByUserId() {
		System.out.println("Enter the user ID");
		int uid = sc.nextInt();
		pDao.fetchByUserIdByFind(uid);

//		System.out.println("Enter the user ID");
//		int uid=sc.nextInt();
//		u=uDao.findId(uid);
//		if(u!=null){
//			pDao.FetchByUserId(uid);
//			
	}

	private static void saveProd() {
		System.out.println("Enter the user ID");
		int uid = sc.nextInt();
		u = uDao.findId(uid);
		if (u != null) {
			System.out.println("Enter the product Name");
			String pname = sc.next();
			System.out.println("Enter the product Category");
			String cat = sc.next();
			System.out.println("Enter the product Brand");
			String brand = sc.next();
			System.out.println("Enter the product Price");
			Double price = sc.nextDouble();

			p.setPname(pname);
			p.setBrand(brand);
			p.setCategory(cat);
			p.setPrice(price);
			p.setUser(u);
			p = pDao.saveProd(p);
			System.out.println("Your products are added in card with User Id " + u.getId());

		}
	}

	private static void userByEmail() {

		System.out.println("Enter the E-mail");
		String email = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();

		u = uDao.fetchByEmail(email, pass);
		if (u != null) {
			System.out.println(u);
		} else {
			System.err.println("No record found");
		}

	}

	private static void userByPhone() {
		System.out.println("Enter the phone");
		long phone = sc.nextLong();
		System.out.println("Enter the password");
		String pass = sc.next();

		u = uDao.fetchByPhone(phone, pass);
		if (u != null) {
			System.out.println(u);
		} else {
			System.err.println("No record found");
		}

	}

	private static void updateUser() {
		System.out.println("Enter you Id to update your details");
		int id = sc.nextInt();
		u = uDao.findId(id);
		if (u != null) {

			System.out.println("Enter you Name");
			String name = sc.next();
			System.out.println("Enter you Phone");
			long phone = sc.nextLong();
			System.out.println("Enter you E-mail");
			String email = sc.next();
			System.out.println("Enter you Password");
			String pass = sc.next();

			u.setId(id);
			u.setName(name);
			u.setPasword(pass);
			u.setPhone(phone);
			u.setEmail(email);
			uDao.saveUser(u);
			System.out.println("Your details are updated");

		} else {
			System.err.println("Invalid Id");
		}

	}

	private static void saveUser() {
		System.out.println("Enter you Name");
		String name = sc.next();
		System.out.println("Enter you Phone");
		long phone = sc.nextLong();
		System.out.println("Enter you E-mail");
		String email = sc.next();
		System.out.println("Enter you Password");
		String pass = sc.next();

		u.setName(name);
		u.setPhone(phone);
		u.setEmail(email);
		u.setPasword(pass);
		uDao.saveUser(u);
		System.out.println("Your record saved with id " + u.getId());

	}
}
