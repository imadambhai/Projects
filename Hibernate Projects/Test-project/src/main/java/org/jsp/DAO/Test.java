package org.jsp.DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.jsp.Controller.control;
import org.jsp.DTO.Department;
import org.jsp.DTO.Employee;

public class Test {
	static Scanner sc=new Scanner(System.in);
	static control c=new control();
	public static void main(String[] args) {
		
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("1. Save the department");
		System.out.println("2. Add the employee for the department");
		System.out.println("3. Update the department");
		System.out.println("4. Update the employee in the department");
		System.out.println("5. Fetch the employees by dept ID");
		System.out.println("6. Fetch the employees by the dept name");
		System.out.println("7. Delete the employee");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Enter your choice");
		int choice=sc.nextInt();
		switch (choice) {
		case 1:
			 save();
			break;
		case 2:
			 addEmp();
			break;
		case 3:
			 updateDept();
			break;
		case 4:
			 updateEmp();
			break;
		case 5:
			 FetchEmpByDeptID();
			break;
		case 6:
			 FetchEmpByDeptName();
			break;
		case 7:
			 deleteEmp();
			break;
		default:
			break;
		}
	}

	private static void deleteEmp() {
		System.out.println("Enter the Employee id ");
		int eid=sc.nextInt();
		Employee e =new Employee();
		e=c.findEmp(eid);
		if(e!=null) {
			c.deleteEmp(e);
		}
		System.out.println("Employee deleted");
	}

	private static void FetchEmpByDeptName() {
		System.out.println("Enter the Department Name ");
		String name=sc.next();
		Department d=new Department();
		c.FetchByName(name);
		
	}

	private static void FetchEmpByDeptID() {
		System.out.println("Enter the Department Id ");
		int id=sc.nextInt();
		Department d=new Department();
		d=c.fetch(id);
		if(d!=null) {
			List<Employee> emps=d.getEmp();
			if(emps!=null) {
				for (Employee e : emps) {
					System.out.println(e.getName());
					
				}
			}
		}else {
			System.err.println("Record not found");
		}
		
	}

	private static void updateEmp() {
		System.out.println("Enter the Department Id ");
		int id=sc.nextInt();
		Department d=new Department();
		d=c.fetch(id);
		if(d!=null) {
		Employee e =new Employee();
		System.out.println("Enter the Employee Id ");
		
		int eid=sc.nextInt();
		
		System.out.println("Enter the employee name");
		String name=sc.next();
		System.out.println("Enter the employee Designation");
		String desg=sc.next();
		System.out.println("Enter the employee salary");
		Double sal=sc.nextDouble();
		System.out.println("Enter the employee phone");
		long phone=sc.nextLong();
		System.out.println("employee the employee password");
		String pass=sc.next();
		e.setId(eid);
		e.setName(name);
		e.setDesg(desg);
		e.setPhone(phone);
		e.setSal(sal);
		e.setPassword(pass);
		e.setDept(d);
		d.setEmp(new ArrayList<Employee>(Arrays.asList(e)));
		c.update(d);
		System.out.println("Employeee updated with id "+e.getId());
		
		}
		
	}

	private static void updateDept() {
		System.out.println("Enter the Department Id ");
		int id=sc.nextInt();
		Department d=new Department();
		if(d!=null) {
		System.out.println("Enter the Department Name");
		String name=sc.next();
		System.out.println("Enter the Department Location");
		String loc=sc.next();
		d=c.fetch(id);
		d.setId(id);
		d.setDname(name);
		d.setLoc(loc);
	    c.save(d);
	    System.out.println("Department updated");
		}
		
		
	}

	private static void addEmp() {
		Employee e =new Employee();
		System.out.println("Enter the Department Id ");
		int id=sc.nextInt();
		System.out.println("Enter the employee name");
		String name=sc.next();
		System.out.println("Enter the employee Designation");
		String desg=sc.next();
		System.out.println("Enter the employee salary");
		Double sal=sc.nextDouble();
		System.out.println("Enter the employee phone");
		long phone=sc.nextLong();
		System.out.println("employee the employee password");
		String pass=sc.next();
		
		Department d=new Department();
		d=c.fetch(id);
		if(d!=null) {
			
			e.setName(name);
			e.setDesg(desg);
			e.setPhone(phone);
			e.setSal(sal);
			e.setPassword(pass);
			e.setDept(d);
			d.setEmp(new ArrayList<Employee>(Arrays.asList(e)));
			c.save(d);
			System.out.println("Employeee saved with id "+e.getId());
			
		}
		
	}

	private static void save() {
		Department d=new Department();
		System.out.println("Enter the Department Name");
		String name=sc.next();
		System.out.println("Enter the Department Location");
		String loc=sc.next();
		
		d.setDname(name);
		d.setLoc(loc);
	    c.save(d);
	    System.out.println("Department saved");
		
		
		
		
	}

}
