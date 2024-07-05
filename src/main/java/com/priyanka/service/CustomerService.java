package com.priyanka.service;

import java.util.List;
import java.util.Optional;

import com.priyanka.entity.CreditCard;
import com.priyanka.entity.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);//save customer details
	
	List<Customer> getAllCustomer();
	
	Optional<Customer> getCustomerById(Long id); 
	
	void deleteCustomer(Long id);
	
	CreditCard issueCreditCard(Long customerId, Long productId, String maker ,String checker);//for issue a credit card
	
	
}
