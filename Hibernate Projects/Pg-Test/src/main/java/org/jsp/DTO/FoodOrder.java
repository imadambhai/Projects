package org.jsp.DTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private double price;
	@Column(nullable = false)
	private String city;
	@Column(nullable = false)
	private String itemname;
	@UpdateTimestamp
	private LocalDate deltime;
	@CreationTimestamp
	private LocalDate ordertime;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public LocalDate getDeltime() {
		return deltime;
	}
	public void setDeltime(LocalDate deltime) {
		this.deltime = deltime;
	}
	public LocalDate getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(LocalDate ordertime) {
		this.ordertime = ordertime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "FoodOrder [id=" + id + ", price=" + price + ", city=" + city + ", itemname=" + itemname + ", deltime="
				+ deltime + ", ordertime=" + ordertime + "]";
	}
	
	

}
