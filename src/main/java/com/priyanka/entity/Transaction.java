package com.priyanka.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity
//@Table(name="Transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionID;
	
	 @Enumerated(EnumType.STRING)
	 @Column(nullable = false)
	 private TransactionType transactionType;
	 
	 @OneToOne
	 @JoinColumn(name="creditcard_id",nullable = false)
	 private CreditCard creditcard;
	 
	 @ManyToOne
	 @JoinColumn(name="creditcard_id",nullable = false)
	 private Merchant merchant;
	 
//	 private double transactionAmount;
//     private String currency;
//	 private String authCode;
	public Transaction(Long transactionID, TransactionType transactionType, CreditCard creditcard, Merchant merchant,
			double transactionAmount, String currency, String authCode) {
		super();
		this.transactionID = transactionID;
		this.transactionType = transactionType;
		this.creditcard = creditcard;
		this.merchant = merchant;
//		this.transactionAmount = transactionAmount;
//		this.currency = currency;
//		this.authCode = authCode;
	}
	 
	 
}
