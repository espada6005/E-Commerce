package com.dailycodework.buynowdotcom.service.cart;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import com.dailycodework.buynowdotcom.model.Cart;
import com.dailycodework.buynowdotcom.model.CartItem;
import com.dailycodework.buynowdotcom.model.Product;
import com.dailycodework.buynowdotcom.repository.CartItemRepository;
import com.dailycodework.buynowdotcom.repository.CartRepository;
import com.dailycodework.buynowdotcom.service.product.ProductService;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final CartService cartService;
    private final ProductService productService;

    @Override
    public void addItemToCart(Long cartId, Long productId, int quantity) {
        Cart cart = cartService.getCart(cartId);
        Product product = productService.getProductById(productId);
        CartItem cartItem = cart.getItems()
            .stream()
            .filter(item -> item.getProduct().getId().equals(productId))
            .findFirst().orElse(new CartItem());

        if (cartItem.getId() == null) {
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItem.setUnitPrice(product.getPrice());
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        }

        cartItem.setTotalPrice();
        cart.addItem(cartItem);
        cartItemRepository.save(cartItem);
        cartRepository.save(cart);
    }

    @Override
    public void removeItemFromCart(Long cartId, Long productId) {
        Cart cart = cartService.getCart(cartId);
        CartItem itemToRemove = getCartItem(cartId, productId);
        cart.removeItem(itemToRemove);
        cartItemRepository.delete(itemToRemove);
        cartRepository.save(cart);
    }

    @Override
    public void updateItemQuantity(Long cartId, Long productId, int quantity) {
        Cart cart = cartService.getCart(cartId);
        cart.getItems().stream()
            .filter(item -> item.getProduct().getId().equals(productId))
            .findFirst().ifPresent(item -> {
                item.setQuantity(quantity);
                item.setUnitPrice(item.getProduct().getPrice());
                item.setTotalPrice();
                cartItemRepository.save(item);
            });
        BigDecimal totalAmount = cart.getItems()
            .stream()
            .map(CartItem::getTotalPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
        cart.setTotalAmount(totalAmount);
        cartRepository.save(cart);
    }

    @Override
    public CartItem getCartItem(Long cartId, Long productId) {
        Cart cart = cartService.getCart(cartId);
        return cart.getItems()
            .stream()
            .filter(item -> item.getProduct().getId().equals(productId))
            .findFirst().orElseThrow(() -> new EntityNotFoundException("Cart not found!"));
    }

}
