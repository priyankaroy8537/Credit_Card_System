package com.priyanka.controller;



import com.priyanka.entity.Transaction;
import com.priyanka.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<Transaction> postTransaction(
            @RequestParam int transactionType,
            @RequestParam String creditcardNumber,
            @RequestParam Long merchantID,
            @RequestParam String currency,
            @RequestParam String authCode,
            @RequestParam double transactionAmount) {
    	
        
        try {
        	System.out.println("hii");
            Transaction transactions = transactionService.postTransaction(
                    transactionType, creditcardNumber, merchantID, currency, authCode, transactionAmount);
            return ResponseEntity.ok(transactions);
        } catch (Exception e) {
        	System.out.println(e);
            return ResponseEntity.badRequest().body(null);
        }
    }
}

