package com.priyanka.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.entity.Merchant;
import com.priyanka.repository.MerchantRepository;
import com.priyanka.service.MerchantService;

@Service
public class MerchantServiceImpl implements MerchantService{

@Autowired	
 private MerchantRepository merchantRepository;

@Override
public Merchant saveMerchant(Merchant merchant) {
	// TODO Auto-generated method stub
	if(merchant.getMerchantEmail()==null || merchant.getMerchantMobile()==null) {
		throw new IllegalArgumentException("Email and mobile number is mandatory");
	}
	return merchantRepository.save(merchant);	
}

@Override
public List<Merchant> getAllMerchants() {
	// TODO Auto-generated method stub
	return merchantRepository.findAll() ;
}

@Override
public Optional<Merchant> getMerchantById(Long id) {
	// TODO Auto-generated method stub
	return merchantRepository.findById(id);
}

@Override
public void deleteMerchant(Long id) {
	// TODO Auto-generated method stub
	merchantRepository.deleteById(id);
	
}
 
}
