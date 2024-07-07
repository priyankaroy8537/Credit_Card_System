package com.priyanka.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.entity.Merchant;
import com.priyanka.repository.MerchantRepository;
import com.priyanka.service.MerchantService;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
    private MerchantRepository merchantRepository;

    @Override
    public Merchant saveMerchant(Merchant merchant) {
        // Validate mandatory fields
        if (merchant.getMerchantMobile() == null || merchant.getMerchantEmail() == null) {
            throw new IllegalArgumentException("Mobile number and email id are mandatory fields to enroll a merchant");
        }

        // Generate unique merchant code (max length 7 digits)
        merchant.setMerchantCode(generateUniqueMerchantCode());

        return merchantRepository.save(merchant);
    }

    @Override
    public List<Merchant> getAllMerchants() {
        return merchantRepository.findAll();
    }

    @Override
    public Optional<Merchant> getMerchantById(Long id) {
        return merchantRepository.findById(id);
    }

    @Override
    public void deleteMerchant(Long id) {
        merchantRepository.deleteById(id);
    }

    private String generateUniqueMerchantCode() {
        // Generate a unique 7-digit merchant code
        return String.valueOf((int) (Math.random() * 9000000) + 1000000);
    }
}
