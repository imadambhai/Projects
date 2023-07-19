package org.jsp.GokulProject.controller;

import java.util.Scanner;

import org.jsp.GokulProject.dao.ProductDao;
import org.jsp.GokulProject.dao.UserDao;
import org.jsp.GokulProject.dto.Product;
import org.jsp.GokulProject.dto.User;

public class Controller {
	static Scanner sc=new Scanner(System.in);
	static User u=new User();
    static	Product p=new Product();
    static	ProductDao pDao=new ProductDao();
    static	UserDao uDao=new UserDao();
	public static void main(String[] args) {
	boolean b=true;
	while(b) {
		System.out.println("1.Save User");
		System.out.println("2.Update User");
		System.out.println("3.Verify User By Phone and Password");
		System.out.println("4.Verify User By Email and Password");
		System.out.println("5.Add Product");
		System.out.println("6.View Product By user id");
		System.out.println("7.View Product By Brand");
		System.out.println("8.View Product By Category");
		System.out.println("9.Delete a Product");
		System.out.println("Enter Your Choice:");
		int choice=sc.nextInt();
		
		switch(choice) {
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
			addProduct();
		break;
		case 6:
			prodByUid();
		break;
		case 7:
			prodByBrand();
		break;
		case 8:
			prodByCat();
		break;
		case 9:
			deleteProd();
			b=false;
		default:
		break;
		}
	}		
	}
	private static void deleteProd() {
		System.out.println("Enter Product id to Delete");
		int pid=sc.nextInt();
		pDao.deleteProd(pid);
	}
	private static void prodByCat() {
		System.out.println("Enter the Category");
		String category=sc.next();
		pDao.prodByCat(category);
	}
	private static void prodByBrand() {
		System.out.println("Enter the Brand");
		String brand=sc.next();
		pDao.prodByBrand(brand);
	}
	private static void prodByUid() {
			System.out.println("Enter your User Id to Display Product Details");
			int uid=sc.nextInt();
			u=uDao.findById(uid);
			if(u!=null) {
				pDao.findPid(uid);
			}
	}
	private static void addProduct() {
		System.out.println("Enter the User id to save Product Details");
		int id=sc.nextInt();
		u=uDao.findById(id);
		if(u!=null)
		System.out.println("Enter the Name");
		String name=sc.next();
		System.out.println("Enter the Brand");
		String brand=sc.next();
		System.out.println("Enter the Category");
		String category=sc.next();
		System.out.println("Enter the Price");
		long price=sc.nextLong();
		
		
		
		Product p=new Product();
		p.setName(name);
		p.setBrand(brand);
		p.setCategory(category);
		p.setPrice(price);
		p.setUser(u);
		p=pDao.saveProduct(p);
		System.out.println("Your Product Saved with Your Id:"+u.getId());
	}
	private static void userByEmail() {
		System.out.println("Enter the Email");
		String email=sc.next();
		System.out.println("Enter the Password");
		String password=sc.next();
		u=uDao.verifyByEmail(email,password);
		if(u!=null) {
			System.out.println(u);
			}else {
				System.out.println("Invalid Details");
			}
	}
	private static void userByPhone() {
		System.out.println("Enter the Phone No");
		long phone=sc.nextLong();
		System.out.println("Enter the Password");
		String password=sc.next();
		u=uDao.verifyByPhone(phone,password);
		if(u!=null) {
			System.out.println(u);
			}else {
				System.out.println("Invalid Details");
			}
	}
	private static void updateUser() {
		System.out.println("Enter the id to Update details");
		int id=sc.nextInt();
		u=uDao.findById(id);
		if(u!=null) {
		System.out.println("Enter the Name");
		String name=sc.next();
		System.out.println("Enter the Phone");
		long phone=sc.nextLong();
		System.out.println("Enter the Email");
		String email=sc.next();
		System.out.println("Enter the Password");
		String password=sc.next();
		
		User u=new User();
		u.setId(id);
		u.setName(name);
		u.setPhone(phone);
		u.setEmail(email);
		u.setPassword(password);
		u=uDao.updateUser(u);
		}else
			System.err.println("enter id invalid");
	}
	private static void saveUser() {
		System.out.println("Enter the Name");
		String name=sc.next();
		System.out.println("Enter the Phone");
		long phone=sc.nextLong();
		System.out.println("Enter the Email");
		String email=sc.next();
		System.out.println("Enter the Password");
		String password=sc.next();
		
		User u=new User();
		u.setName(name);
		u.setPhone(phone);
		u.setEmail(email);
		u.setPassword(password);
		u=uDao.saveUser(u);
	}

}
