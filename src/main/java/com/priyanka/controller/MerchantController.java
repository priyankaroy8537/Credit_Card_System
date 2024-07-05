package com.priyanka.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priyanka.entity.Customer;
import com.priyanka.entity.Merchant;
import com.priyanka.entity.Product;
import com.priyanka.service.MerchantService;

@RestController
@RequestMapping("/merchant")
public class MerchantController {
	
	@Autowired
	private MerchantService merchantService;
	
	@PostMapping
	public ResponseEntity<Merchant> saveCustomer( @RequestBody Merchant merchant){
		Merchant saveMerchant =merchantService.saveMerchant(merchant);
		return ResponseEntity.ok(merchant) ;
		
	}
	@GetMapping
	public ResponseEntity<List<Merchant>> getAllMerchants(){
		List<Merchant> merchant = merchantService.getAllMerchants();
		return ResponseEntity.ok(merchant) ;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Merchant>>getMerchantById(@PathVariable Long id){
		Optional<Merchant>product =merchantService.getMerchantById(id);
		return ResponseEntity.ok(product);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Customer> deleteCustomer( @PathVariable Long id){
		merchantService.deleteMerchant(id);
		return ResponseEntity.noContent().build();
		
	} 

}
