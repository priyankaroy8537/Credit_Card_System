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

@Entity
@Table(name="Transaction")
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
	 
	 @ManyToOne
	 @JoinColumn(name="creditcard_id",nullable = false)
	 private CreditCard creditcard;
	 
	 @ManyToOne
	 @JoinColumn(name="merchant_id", nullable = false)
	 private Merchant merchant;
	    
	 private double transactionAmount;
	 private String currency;
	 private String authCode;
	 
	 public Transaction() {
		 
	 }
	public Transaction(Long transactionID, TransactionType transactionType, CreditCard creditcard, Merchant merchant,
			double transactionAmount, String currency, String authCode) {
		super();
		this.transactionID = transactionID;
		this.transactionType = transactionType;
		this.creditcard = creditcard;
		this.merchant = merchant;
		this.transactionAmount = transactionAmount;
		this.currency = currency;
		this.authCode = authCode;
	}
	public Long getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(Long transactionID) {
		this.transactionID = transactionID;
	}
	public TransactionType getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	public CreditCard getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(CreditCard creditcard) {
		this.creditcard = creditcard;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getAuthCode() {
		return authCode;
	}
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}
	 
}
