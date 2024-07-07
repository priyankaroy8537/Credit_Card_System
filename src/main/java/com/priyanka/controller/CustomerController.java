package com.priyanka.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.priyanka.entity.CreditCard;
import com.priyanka.entity.Customer;
import com.priyanka.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	 @Autowired
	    private CustomerService customerService;

	    @PostMapping
	    public ResponseEntity<Customer> saveCustomer(@Validated @RequestBody Customer customer) {
	        Customer savedCustomer = customerService.saveCustomer(customer);
	        return ResponseEntity.ok(savedCustomer);
	    }

	    @GetMapping
	    public ResponseEntity<List<Customer>> getAllCustomers() {
	        List<Customer> customers = customerService.getAllCustomers();
	        return ResponseEntity.ok(customers);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
	        Optional<Customer> customer = customerService.getCustomerById(id);
	        if (customer.isPresent()) {
	            return ResponseEntity.ok(customer.get());
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
	        customerService.deleteCustomer(id);
	        return ResponseEntity.noContent().build();
	    }

	    @PostMapping("/{customerId}/issueCreditCard")
	    public ResponseEntity<CreditCard> issueCreditCard(
	            @PathVariable Long customerId,
	            @RequestParam Long productId,
	            @RequestParam String maker,
	            @RequestParam String checker) {
	        CreditCard issuedCard = customerService.issueCreditCard(customerId, productId, maker, checker);
	        return ResponseEntity.ok(issuedCard);
	    }
}
