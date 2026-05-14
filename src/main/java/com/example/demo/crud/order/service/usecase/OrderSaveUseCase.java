package com.example.demo.crud.order.service.usecase;

import com.example.demo.crud.order.domain.Order;

public interface OrderSaveUseCase {
    Order save(Long productId);
}

