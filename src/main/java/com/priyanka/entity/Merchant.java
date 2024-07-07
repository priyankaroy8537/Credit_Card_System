package com.priyanka.entity;

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
@Table(name="Merchnt")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Merchant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long merchantID;
	    private String merchantName;
	    private String merchantAddress;
	    private String merchantMobile;
	    private String merchantEmail;
	    private String merchantBankAcc;
	    private String merchantIFSC;
	    private String merchantBankName;
	    private String merchantLocation;
	    private String merchantCode;
	    
	    @Enumerated(EnumType.STRING)
	    private MerchantStatus merchantStatus;
	    
	    public Merchant() {
	    	
	    }

		public Merchant(Long merchantID, String merchantName, String merchantAddress, String merchantMobile,
				String merchantEmail, String merchantBankAcc, String merchantIFSC, String merchantBankName,
				String merchantLocation, String merchantCode, MerchantStatus merchantStatus) {
			super();
			this.merchantID = merchantID;
			this.merchantName = merchantName;
			this.merchantAddress = merchantAddress;
			this.merchantMobile = merchantMobile;
			this.merchantEmail = merchantEmail;
			this.merchantBankAcc = merchantBankAcc;
			this.merchantIFSC = merchantIFSC;
			this.merchantBankName = merchantBankName;
			this.merchantLocation = merchantLocation;
			this.merchantCode = merchantCode;
			this.merchantStatus = merchantStatus;
		}

		public Long getMerchantID() {
			return merchantID;
		}

		public void setMerchantID(Long merchantID) {
			this.merchantID = merchantID;
		}

		public String getMerchantName() {
			return merchantName;
		}

		public void setMerchantName(String merchantName) {
			this.merchantName = merchantName;
		}

		public String getMerchantAddress() {
			return merchantAddress;
		}

		public void setMerchantAddress(String merchantAddress) {
			this.merchantAddress = merchantAddress;
		}

		public String getMerchantMobile() {
			return merchantMobile;
		}

		public void setMerchantMobile(String merchantMobile) {
			this.merchantMobile = merchantMobile;
		}

		public String getMerchantEmail() {
			return merchantEmail;
		}

		public void setMerchantEmail(String merchantEmail) {
			this.merchantEmail = merchantEmail;
		}

		public String getMerchantBankAcc() {
			return merchantBankAcc;
		}

		public void setMerchantBankAcc(String merchantBankAcc) {
			this.merchantBankAcc = merchantBankAcc;
		}

		public String getMerchantIFSC() {
			return merchantIFSC;
		}

		public void setMerchantIFSC(String merchantIFSC) {
			this.merchantIFSC = merchantIFSC;
		}

		public String getMerchantBankName() {
			return merchantBankName;
		}

		public void setMerchantBankName(String merchantBankName) {
			this.merchantBankName = merchantBankName;
		}

		public String getMerchantLocation() {
			return merchantLocation;
		}

		public void setMerchantLocation(String merchantLocation) {
			this.merchantLocation = merchantLocation;
		}

		public String getMerchantCode() {
			return merchantCode;
		}

		public void setMerchantCode(String merchantCode) {
			this.merchantCode = merchantCode;
		}

		public MerchantStatus getMerchantStatus() {
			return merchantStatus;
		}

		public void setMerchantStatus(MerchantStatus merchantStatus) {
			this.merchantStatus = merchantStatus;
		}

		
	    
}
