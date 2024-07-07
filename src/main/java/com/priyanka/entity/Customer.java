package com.priyanka.entity;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long customerID;
	    private String name;
	    private LocalDate dob;
	    private String address;
	    private String mobile;
	    private String pan;
	    private String email;
	    
	    public Customer() {
	    }
	    
		public Customer(Long customerID, String name, LocalDate dob, String address, String mobile, String pan,
				String email) {
			super();
			this.customerID = customerID;
			this.name = name;
			this.dob = dob;
			this.address = address;
			this.mobile = mobile;
			this.pan = pan;
			this.email = email;
		}

		public Long getCustomerID() {
			return customerID;
		}

		public void setCustomerID(Long customerID) {
			this.customerID = customerID;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public LocalDate getDob() {
			return dob;
		}

		public void setDob(LocalDate dob) {
			this.dob = dob;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}

		public String getPan() {
			return pan;
		}

		public void setPan(String pan) {
			this.pan = pan;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
	    
	    
		


		
}
