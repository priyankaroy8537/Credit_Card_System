package com.priyanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.priyanka.entity.CreditCard;



@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
	@Query("SELECT c FROM CreditCard c WHERE c.creditcardNumber = ?1")
	public CreditCard getByNumber(String number);
}
