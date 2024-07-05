package com.priyanka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.priyanka.entity.Merchant;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

}
