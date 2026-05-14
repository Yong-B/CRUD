package com.example.demo.crud.order.service.usecase;

import com.example.demo.crud.order.domain.Order;

import java.util.List;

public interface OrderSelectOneUseCase {
    Order findById(Long orderId);
}
