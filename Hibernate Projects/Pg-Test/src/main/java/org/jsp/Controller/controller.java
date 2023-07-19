package org.jsp.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.jsp.DAO.FoodDao;
import org.jsp.DAO.UserDao;
import org.jsp.DTO.FoodOrder;
import org.jsp.DTO.User;

public class controller {
	static Scanner sc = new Scanner(System.in);
	static User u = new User();
	static FoodOrder f = new FoodOrder();
	static FoodDao fDao = new FoodDao();
	static UserDao uDao = new UserDao();

	public static void main(String[] args) {
		System.out.println("1. Save the User");
		System.out.println("2. Verify user by email and password");
		System.out.println("3. Add the foodorder");
		System.out.println("4. Update the User");
		System.out.println("5. Update the foodorder");
		System.out.println("6. Fetch the foodorders by email and password");
		System.out.println("7. Delete the foodorder");
		System.out.println("8. update foodorder phone and password");
		System.out.println("9. Fetch the foodorder by user name");
		System.out.println("10.Fetch foodorder by itemname");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();

		switch (choice) {
		case 1:
			saveUser();
			break;
		case 2:
			byEmailAndPass();
			break;
		case 3:
			saveFoodorder();
			break;
		case 4:
			updateUser();
			break;
		case 5:
			updateFood();
			break;
		case 6:
			foodByEmailAndPass();
			break;
		case 7:
			deleteFood();
			break;
		case 8:
			updateFoodByPhAndPass();
			break;
		case 9:
			FetchFoodByUserName();
			break;
		case 10:
			FetchFoodByFoodName();
			break;

		default:
			break;
		}

	}

	private static void FetchFoodByFoodName() {
		System.out.println("enter the Food name");
		String fname=sc.next();
		List<FoodOrder> fds=fDao.FetchByFoodName(fname);
		for (FoodOrder f : fds) {
			System.out.println(f);
			
		}
	}

	private static void FetchFoodByUserName() {
		System.out.println("Enter the User Name");
		String name=sc.next();
		List<FoodOrder> fds=fDao.FetchByUserName(name);
		for (FoodOrder f : fds) {
			System.out.println(f);
			
		}
		
		
	}

	private static void updateFoodByPhAndPass() {
		System.out.println("Enter the Phone");
		long phone=sc.nextLong();
		System.out.println("Enter the Password");
		String pass=sc.next();
		u=fDao.findByPhoneByPass(phone,pass);
		
		if (u != null) {
			System.out.println("Enter the food Id");
			int fid = sc.nextInt();
			System.out.println("Enter the ItemName");
			String fname = sc.next();
			System.out.println("Enter the city name");
			String city = sc.next();
			System.out.println("Enter the price");
			double price = sc.nextDouble();
			f.setId(fid);
			f.setItemname(fname);
			f.setCity(city);
			f.setPrice(price);
			f.setUser(u);
			u.setFood(new ArrayList<FoodOrder>(Arrays.asList(f)));
			uDao.saveUpdate(u);
			System.out.println("Your Foodorder is saved");

		}
		
		
		
	}

	private static void deleteFood() {
		System.out.println("Enter the food Id");
		int fid = sc.nextInt();
		f = fDao.findById(fid);
		if (f != null) {
			fDao.deleteFood(f);
			System.out.println("Your Foodorder is deleted");
		}

		else {
			System.err.println("Record not found");
		}
	}

	private static void foodByEmailAndPass() {
		System.out.println("Enter the E-mail");
		String email = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		f = fDao.verifyByEmailAndPass(email, pass);

	}

	private static void updateFood() {
		System.out.println("Enter User Id");
		int uid = sc.nextInt();
		u = uDao.findById(uid);
		System.out.println("Enter the Food Id");
		int fid = sc.nextInt();
		f = fDao.findById(fid);
		if (f != null) {
			System.out.println("Enter the ItemName");
			String fname = sc.next();
			System.out.println("Enter the city name");
			String city = sc.next();
			System.out.println("Enter the price");
			double price = sc.nextDouble();
			f.setId(fid);
			f.setItemname(fname);
			f.setCity(city);
			f.setPrice(price);
			f.setUser(u);
			u.setFood(new ArrayList<FoodOrder>(Arrays.asList(f)));
			uDao.saveUpdate(u);
			System.out.println("Your Foodorder is saved");

		}
	}

	private static void updateUser() {
		System.out.println("Enter User Id");
		int uid = sc.nextInt();
		u = uDao.findById(uid);
		if (u != null) {
			System.out.println("Enter the Name");
			String name = sc.next();
			System.out.println("Enter the gender");
			String gender = sc.next();
			System.out.println("Enter the email");
			String email = sc.next();
			System.out.println("Enter the phone");
			long phone = sc.nextLong();
			System.out.println("Enter the password");
			String pass = sc.next();
			u.setId(uid);
			u.setName(name);
			u.setGender(gender);
			u.setEmail(email);
			u.setPhone(phone);
			u.setPassword(pass);
			uDao.saveUser(u);

		}
	}

	private static void saveFoodorder() {
		System.out.println("Enter the UserId ");
		int uid = sc.nextInt();
		u = uDao.findById(uid);
		if (u != null) {
			System.out.println("Enter the ItemName");
			String fname = sc.next();
			System.out.println("Enter the city name");
			String city = sc.next();
			System.out.println("Enter the price");
			double price = sc.nextDouble();

			f.setItemname(fname);
			f.setCity(city);
			f.setPrice(price);
			f.setUser(u);
			u.setFood(new ArrayList<FoodOrder>(Arrays.asList(f)));
			uDao.saveFood(u);
			System.out.println("Your Foodorder is saved");

		}

	}

	private static void byEmailAndPass() {
		System.out.println("Enter your Email");
		String email = sc.next();
		System.out.println("Enter your password");
		String pass = sc.next();

		u = uDao.VerifyByMailAndPass(email, pass);
		if (u != null) {
			System.out.println(u.getName() + " Your Account verified");
		} else {
			System.err.println("Your Id is invalid");
		}
	}

	private static void saveUser() {
		System.out.println("Enter the Name");
		String name = sc.next();
		System.out.println("Enter the gender");
		String gender = sc.next();
		System.out.println("Enter the email");
		String email = sc.next();
		System.out.println("Enter the phone");
		long phone = sc.nextLong();
		System.out.println("Enter the password");
		String pass = sc.next();
		u.setName(name);
		u.setGender(gender);
		u.setEmail(email);
		u.setPhone(phone);
		u.setPassword(pass);
		uDao.saveUser(u);
		System.out.println("Your record is saved by id " + u.getId());

	}

}
