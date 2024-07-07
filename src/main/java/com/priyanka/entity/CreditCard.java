package com.priyanka.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CreditCard")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long creditID;
	 private String creditcardNumber;
	 private LocalDate creditcardExpiry;
	 private int cvv;
	 private double creditLimit;
	 private String Creditcardstatus;
	 private String maker;
	 private String checker;
	 private double dailyExpence;
	 
	 @ManyToOne
	 @JoinColumn(name="customer_id",nullable = false)
	 private Customer customer;
	 
	 @ManyToOne
	 @JoinColumn(name="product_id",nullable = false) 
	 private Product product;
	 
	 public CreditCard() {
		 
	 }

	public CreditCard(Long creditID, String creditcardNumber, LocalDate creditcardExpiry, int cvv, double creditLimit,
			String creditcardstatus, String maker, String checker, double dailyExpence, Customer customer,
			Product product) {
		super();
		this.creditID = creditID;
		this.creditcardNumber = creditcardNumber;
		this.creditcardExpiry = creditcardExpiry;
		this.cvv = cvv;
		this.creditLimit = creditLimit;
		Creditcardstatus = creditcardstatus;
		this.maker = maker;
		this.checker = checker;
		this.dailyExpence = dailyExpence;
		this.customer = customer;
		this.product = product;
	}

	public Long getCreditID() {
		return creditID;
	}

	public void setCreditID(Long creditID) {
		this.creditID = creditID;
	}

	public String getCreditcardNumber() {
		return creditcardNumber;
	}

	public void setCreditcardNumber(String creditcardNumber) {
		this.creditcardNumber = creditcardNumber;
	}

	public LocalDate getCreditcardExpiry() {
		return creditcardExpiry;
	}

	public void setCreditcardExpiry(LocalDate creditcardExpiry) {
		this.creditcardExpiry = creditcardExpiry;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getCreditcardstatus() {
		return Creditcardstatus;
	}

	public void setCreditcardstatus(String creditcardstatus) {
		Creditcardstatus = creditcardstatus;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public double getDailyExpence() {
		return dailyExpence;
	}

	public void setDailyExpence(double dailyExpence) {
		this.dailyExpence = dailyExpence;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	 
	
}
