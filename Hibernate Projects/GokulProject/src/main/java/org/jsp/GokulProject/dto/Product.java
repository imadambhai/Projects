package org.jsp.GokulProject.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String name;
private String brand;
private String category;
private long price;

@Override
public String toString() {
	return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", category=" + category + ", price=" + price
			+ "]";
}

@ManyToOne
@JoinColumn
private User user;

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}
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
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public long getPrice() {
	return price;
}
public void setPrice(long price) {
	this.price = price;
}
}
