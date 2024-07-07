package com.priyanka.service;

import java.util.List;
import java.util.Optional;

import com.priyanka.entity.Merchant;

public interface MerchantService {
	Merchant saveMerchant(Merchant merchant);
    List<Merchant> getAllMerchants();
    Optional<Merchant> getMerchantById(Long id);
    void deleteMerchant(Long id);
}
