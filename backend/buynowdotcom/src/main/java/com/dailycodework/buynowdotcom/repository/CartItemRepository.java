package com.dailycodework.buynowdotcom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailycodework.buynowdotcom.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByProductId(Long productId);
}
