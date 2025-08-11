package com.dailycodework.buynowdotcom.service.order;

import java.util.List;

import com.dailycodework.buynowdotcom.dtos.OrderDto;
import com.dailycodework.buynowdotcom.model.Order;

public interface OrderService {

    Order placeOrder(Long userId);

    List<OrderDto> getUserOrders(Long userId);

    OrderDto convertDto(Order order);

}
