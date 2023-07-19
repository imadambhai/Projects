package org.jsp.DTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="person")

@NamedQueries(value= {@NamedQuery(name="findByAge", query="select p from Person p where p.age=?1"),
		@NamedQuery(name="findByPhone", query="select p from Person p where p.phone=?1"),
		@NamedQuery(name="findByEmail", query="select p from Person p where p.email=?1"),
		@NamedQuery(name="findByName", query="select p from Person p where p.name=?1"),
		@NamedQuery(name="fetchAllPersons", query="select p.name from Person p"),
		@NamedQuery(name="fetchAllAgeById", query="select p.age from Person p where p.id=?1")})
public class Person {
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + "]";
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false,unique = true)
	private long phone;
	@Column(nullable = false,unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	

}
