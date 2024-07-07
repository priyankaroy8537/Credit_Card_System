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

import com.priyanka.entity.Merchant;
import com.priyanka.service.MerchantService;

@RestController
@RequestMapping("/merchants")
public class MerchantController {
	@Autowired
    private MerchantService merchantService;

    @PostMapping
    public ResponseEntity<Merchant> saveMerchant(@RequestBody Merchant merchant) {
        Merchant savedMerchant = merchantService.saveMerchant(merchant);
        return ResponseEntity.ok(savedMerchant);
    }

    @GetMapping
    public ResponseEntity<List<Merchant>> getAllMerchants() {
        List<Merchant> merchants = merchantService.getAllMerchants();
        return ResponseEntity.ok(merchants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Merchant>> getMerchantById(@PathVariable Long id) {
        Optional<Merchant> merchant = merchantService.getMerchantById(id);
        return ResponseEntity.ok(merchant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMerchant(@PathVariable Long id) {
        merchantService.deleteMerchant(id);
        return ResponseEntity.noContent().build();
    }
}
