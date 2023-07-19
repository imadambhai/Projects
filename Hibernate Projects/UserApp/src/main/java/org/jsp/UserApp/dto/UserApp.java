package org.jsp.UserApp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UserApp {	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name,gender,password;
		@Column(unique = true, nullable = false, name="email")
		private String email;
		@Column(unique = true, nullable = false)
		private long phone;
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
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public long getPhone() {
			return phone;
		}
		public void setPhone(long phone) {
			this.phone = phone;
		}
		@Override
		public String toString() {
			return "id=" + id + ", name=" + name + ", gender=" + gender + ", password=" + password + ", email="
					+ email + ", phone=" + phone + "";
		}
		
		
	

}
