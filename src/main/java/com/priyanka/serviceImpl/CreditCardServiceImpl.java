package com.priyanka.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.priyanka.entity.CreditCard;
import com.priyanka.repository.CreditCardRepository;
import com.priyanka.service.CreditCardService;
@Service
public class CreditCardServiceImpl implements CreditCardService{
	@Autowired
	private CreditCardRepository creditCardRepository;

	@Override
	public CreditCard getByNumber(String number) {
		CreditCard creditcard=creditCardRepository.getByNumber(number);
		// TODO Auto-generated method stub
		return creditcard;
	}

}
