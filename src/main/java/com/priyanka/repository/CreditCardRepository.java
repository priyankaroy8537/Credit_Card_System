package com.priyanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priyanka.entity.CreditCard;



@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
//	@Query(value="select a from credit_card a where a.creditcard_number=?1")
//	public CreditCard getByNumber(String number);
}
