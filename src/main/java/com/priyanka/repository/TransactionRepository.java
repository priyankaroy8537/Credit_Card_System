package com.priyanka.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.priyanka.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	@Query("SELECT t FROM Transaction t JOIN t.creditcard cc WHERE cc.creditcardNumber = ?1")
    List<Transaction> findByCreditCardNumber( String creditCardNumber);
}
