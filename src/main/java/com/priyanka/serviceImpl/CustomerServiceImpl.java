package com.priyanka.serviceImpl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.entity.CardType;
import com.priyanka.entity.CreditCard;
import com.priyanka.entity.Customer;
import com.priyanka.entity.Product;
import com.priyanka.repository.CreditCardRepository;
import com.priyanka.repository.CustomerRepository;
import com.priyanka.repository.ProductRepository;
import com.priyanka.service.CustomerService;

import jakarta.validation.Valid;

@Service
public class CustomerServiceImpl implements CustomerService {
	 @Autowired
	    private CustomerRepository customerRepository;

	    @Autowired
	    private ProductRepository productRepository;

	    @Autowired
	    private CreditCardRepository creditCardRepository;

	    @Override
	    public Customer saveCustomer(@Valid Customer customer) {
	        // Validate mandatory fields
	        if (customer.getPan() == null || customer.getMobile() == null || customer.getEmail() == null) {
	            throw new IllegalArgumentException("PAN, mobile # and email id are mandatory fields to issue a credit card");
	        }
	        return customerRepository.save(customer);
	    }

	    @Override
	    public List<Customer> getAllCustomers() {
	        return customerRepository.findAll();
	    }

	    @Override
	    public Optional<Customer> getCustomerById(Long id) {
	        return customerRepository.findById(id);
	    }

	    @Override
	    public void deleteCustomer(Long id) {
	        customerRepository.deleteById(id);
	    }

	    @Override
	    public CreditCard issueCreditCard(Long customerId, Long productId, String maker, String checker) {
	        Customer customer = customerRepository.findById(customerId)
	                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

	        Product product = productRepository.findById(productId)
	                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

	        // Generate card number
	        String cardNumberPrefix;
	        if (product.getCardType()== CardType.VISA) {
	            cardNumberPrefix = "4";
	        } else if (product.getCardType()== CardType.MASTERCARD) {
	            cardNumberPrefix = "5";
	        } else {
	            throw new IllegalArgumentException("Unsupported card type");
	        }

	        String cardNumber = cardNumberPrefix + generateCardNumberSequence();
	        //String cardNumberPrefix = product.getProductDescription().equalsIgnoreCase("VISA") ? "4" : "5";
	        //String cardNumber = cardNumberPrefix + generateCardNumberSequence();

	        // Calculate expiry date
	        LocalDate expiryDate = LocalDate.now().plusMonths(product.getProductExpiry());
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYMM");
	        String expiryDateFormatted = expiryDate.format(formatter); 

	        // Create CreditCard entity
	        CreditCard creditCard = new CreditCard(productId, expiryDateFormatted, expiryDate, 0, productId, expiryDateFormatted, expiryDateFormatted, expiryDateFormatted,0, customer, product);
	        creditCard.setCreditcardNumber(cardNumber);
	        creditCard.setCreditcardExpiry(expiryDate);
	        creditCard.setCvv((int) (Math.random() * 900) + 100); // Generate random 3-digit CVV
	        creditCard.setCreditLimit(product.getProductLimit());
	        creditCard.setCreditcardstatus("open"); // Default status
	        creditCard.setMaker(maker);
	        creditCard.setChecker(checker);
	        creditCard.setCustomer(customer);
	        creditCard.setProduct(product);
	        creditCard.setDailyExpence(0);

	        return creditCardRepository.save(creditCard);
	    }

	    private String generateCardNumberSequence() {
	        // Generate a 15-digit sequence number (assuming you have a sequence generator in your DB)
	        // For example purposes, we will just generate a random number
	        long number = (long) (Math.random() * 1_000_000_000_000_000L);
	        return String.format("%015d", number);
	    }
}
