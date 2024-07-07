package com.priyanka.service;

import java.util.List;
import java.util.Optional;

import com.priyanka.entity.CreditCard;
import com.priyanka.entity.Customer;

public interface CustomerService {
	 
    Customer saveCustomer(Customer customer);// Method to save customer details
    List<Customer> getAllCustomers(); // Method to get all customers 

    Optional<Customer> getCustomerById(Long id); // Method to get a customer by ID

    void deleteCustomer(Long id);// Method to delete a customer by ID

    CreditCard issueCreditCard(Long customerId, Long productId, String maker, String checker);// Method to issue a credit card to a customer
}
