package com.dailycodework.buynowdotcom.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodework.buynowdotcom.dtos.OrderDto;
import com.dailycodework.buynowdotcom.model.Order;
import com.dailycodework.buynowdotcom.response.ApiResponse;
import com.dailycodework.buynowdotcom.service.order.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/orders")
public class OrderController {

    private OrderService orderService;

    @PostMapping("/user/oder")
    public ResponseEntity<ApiResponse> placeOrder(@RequestParam Long userId) {
        Order order = orderService.placeOrder(userId);
        OrderDto orderDto = orderService.convertDto(order);
        return ResponseEntity.ok(new ApiResponse("Order placed successfully!", orderDto));
    }
    
    @GetMapping("/user/{userId}/order")
    public ResponseEntity<ApiResponse> getUserOrders(@PathVariable Long userId) {
        List<OrderDto> orserDtos = orderService.getUserOrders(userId);
        return ResponseEntity.ok(new ApiResponse("Success!", orserDtos));
    }
    

}
