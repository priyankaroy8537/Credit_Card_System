package com.priyanka.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.entity.CreditCard;
import com.priyanka.entity.Merchant;
import com.priyanka.entity.MerchantStatus;
import com.priyanka.entity.Transaction;
import com.priyanka.entity.TransactionType;
import com.priyanka.repository.CreditCardRepository;
import com.priyanka.repository.MerchantRepository;
import com.priyanka.repository.TransactionRepository;
import com.priyanka.service.TransactionService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public Transaction postTransaction(int transactionType, String creditcardNumber, Long merchantID, String currency, String authCode,double transactionAmount) {
        CreditCard creditCard = null;
        Merchant merchant = null;
        

        try {
            // Validate credit card number
            creditCard = creditCardRepository.getByNumber(creditcardNumber);
            if (creditCard == null) {
                throw new IllegalArgumentException("Invalid credit card number");
            }
            if (!creditCard.getCreditcardstatus().equals("open")) {
                throw new IllegalArgumentException("Credit card inactive");
            }

           
            merchant = merchantRepository.findById(merchantID)
                .orElseThrow(() -> new IllegalArgumentException("Invalid merchant code"));
            if (!(merchant.getMerchantStatus() == MerchantStatus.ACTIVE)) {
                throw new IllegalArgumentException("Merchant is not available");
            }

           
            switch (transactionType) {
                case 1:
                    
                    Transaction balanceEnquiryTransaction = new Transaction();
                    balanceEnquiryTransaction.setAuthCode(authCode);
                    balanceEnquiryTransaction.setCreditcard(creditCard);
                    balanceEnquiryTransaction.setCurrency(currency);
                    balanceEnquiryTransaction.setMerchant(merchant);
                    balanceEnquiryTransaction.setTransactionAmount(creditCard.getCreditLimit());
                    balanceEnquiryTransaction.setTransactionType(TransactionType.BalanceEnquiry);
                    
                    transactionRepository.save(balanceEnquiryTransaction);
                  
                    return balanceEnquiryTransaction;

                case 3:
                    
                	creditCard.setCreditLimit(creditCard.getCreditLimit() + transactionAmount);
                    creditCardRepository.save(creditCard);
                    Transaction paymentsTransaction = new Transaction();
                    paymentsTransaction.setAuthCode(generateAuthCode());
                    paymentsTransaction.setCreditcard(creditCard);
                    paymentsTransaction.setCurrency(currency);
                    paymentsTransaction.setMerchant(merchant);
                    paymentsTransaction.setTransactionAmount(transactionAmount);
                    paymentsTransaction.setTransactionType(TransactionType.Payments);
                    
                    Transaction paymentTransaction = transactionRepository.save(paymentsTransaction);
                    
                    return paymentTransaction;
                   

                case 2:
                   
                    if (creditCard.getCreditLimit() < transactionAmount) {
                        throw new IllegalArgumentException("Insufficient credit limit");
                    }
                   
                    if (!checkPerDayLimit(creditCard, transactionAmount)) {
                        throw new IllegalArgumentException("Exceeds per day limit");
                    }
                    
                    creditCard.setCreditLimit(creditCard.getCreditLimit() - transactionAmount);
                    creditCard.setDailyExpence(creditCard.getDailyExpence()+transactionAmount);
                    creditCardRepository.save(creditCard);
                    Transaction purchaseTransaction = new Transaction();
                    purchaseTransaction.setAuthCode(generateAuthCode());
                    purchaseTransaction.setCreditcard(creditCard);
                    purchaseTransaction.setCurrency(currency);
                    purchaseTransaction.setMerchant(merchant);
                    purchaseTransaction.setTransactionAmount(transactionAmount);
                    purchaseTransaction.setTransactionType(TransactionType.Purchases);
                    
                    Transaction purchasesTransaction = transactionRepository.save(purchaseTransaction);
                    
                    return purchasesTransaction;

                default:
                    throw new IllegalArgumentException("Unsupported transaction type");
            }

        } catch (Exception e) {
            
            Transaction cancellationTransaction = new Transaction();
            cancellationTransaction.setTransactionType(TransactionType.Cancellation);
            cancellationTransaction.setCreditcard(creditCard);
            cancellationTransaction.setMerchant(merchant);
            cancellationTransaction.setAuthCode(generateAuthCode());
            transactionRepository.save(cancellationTransaction);
           
            throw e;
        }
    }

    private boolean checkPerDayLimit(CreditCard creditCard, double amount) {
        
        double dailyExpense = creditCard.getDailyExpence();
        double limit = creditCard.getProduct().getProductLimit();
        double currentLimit = limit - dailyExpense;
        return amount <= currentLimit;
    }

    private String generateAuthCode() {
        return String.format("%06d", (int) (Math.random() * 1_000_000));
    }
}
