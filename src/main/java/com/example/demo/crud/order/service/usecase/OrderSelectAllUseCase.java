package com.example.demo.crud.order.service.usecase;

import com.example.demo.crud.order.domain.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderSelectAllUseCase {
    Page<Order> findAll(Pageable pageable);
}
