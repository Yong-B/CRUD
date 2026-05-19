package com.example.demo.crud.order.service.usecase;

import com.example.demo.crud.order.domain.Order;

public interface OrderSelectOneUseCase {
    Order findById(Long orderId);
}
