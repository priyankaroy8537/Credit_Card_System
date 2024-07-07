package com.priyanka.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long productID;
	    
	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private ProductType productType;
	    private String productDescription;
	    private String productBinValue;
	    private String productSubBinValue;
	    private int productExpiry;
	    private double productLimit;
	    private int productPayment;
	    
	    @Enumerated(EnumType.STRING)
	    private CardType cardType;
	    
	    public  Product() {
			// TODO Auto-generated constructor stub
		}

		public Product(Long productID, ProductType productType, String productDescription, String productBinValue,
				String productSubBinValue, int productExpiry, double productLimit, int productPayment,
				CardType cardType) {
			super();
			this.productID = productID;
			this.productType = productType;
			this.productDescription = productDescription;
			this.productBinValue = productBinValue;
			this.productSubBinValue = productSubBinValue;
			this.productExpiry = productExpiry;
			this.productLimit = productLimit;
			this.productPayment = productPayment;
			this.cardType = cardType;
		}

		public Long getProductID() {
			return productID;
		}

		public void setProductID(Long productID) {
			this.productID = productID;
		}

		public ProductType getProductType() {
			return productType;
		}

		public void setProductType(ProductType productType) {
			this.productType = productType;
		}

		public String getProductDescription() {
			return productDescription;
		}

		public void setProductDescription(String productDescription) {
			this.productDescription = productDescription;
		}

		public String getProductBinValue() {
			return productBinValue;
		}

		public void setProductBinValue(String productBinValue) {
			this.productBinValue = productBinValue;
		}

		public String getProductSubBinValue() {
			return productSubBinValue;
		}

		public void setProductSubBinValue(String productSubBinValue) {
			this.productSubBinValue = productSubBinValue;
		}

		public int getProductExpiry() {
			return productExpiry;
		}

		public void setProductExpiry(int productExpiry) {
			this.productExpiry = productExpiry;
		}

		public double getProductLimit() {
			return productLimit;
		}

		public void setProductLimit(double productLimit) {
			this.productLimit = productLimit;
		}

		public int getProductPayment() {
			return productPayment;
		}

		public void setProductPayment(int productPayment) {
			this.productPayment = productPayment;
		}

		public CardType getCardType() {
			return cardType;
		}

		public void setCardType(CardType cardType) {
			this.cardType = cardType;
		}
	    
	    
		
		
	    
	    
	    
}
