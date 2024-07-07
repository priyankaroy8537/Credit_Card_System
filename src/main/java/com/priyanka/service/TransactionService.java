package com.priyanka.service;

import java.util.List;

import com.priyanka.entity.Transaction;

public interface TransactionService {
	 public Transaction postTransaction(int transactionType, String creditcardNaumber, Long merchantID,String currency,String authCode,double transactionAmount);
}
