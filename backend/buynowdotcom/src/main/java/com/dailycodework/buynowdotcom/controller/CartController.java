package com.dailycodework.buynowdotcom.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodework.buynowdotcom.model.Cart;
import com.dailycodework.buynowdotcom.response.ApiResponse;
import com.dailycodework.buynowdotcom.service.cart.CartService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/carts")
public class CartController {

    private final CartService cartService;

    @GetMapping("/user/{userId}/cart")
    public ResponseEntity<ApiResponse> getUserCart(@PathVariable Long userId) {
        Cart cart = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(new ApiResponse("Success", cart));
    }

    @DeleteMapping("/cart/{cartId}/clear")
    public void clearCart(@PathVariable Long cartId) {
        cartService.clearCart(cartId);
    }

}
