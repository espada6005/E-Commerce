package com.dailycodework.buynowdotcom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailycodework.buynowdotcom.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByUserId(Long userId);

    

}
