package com.example.demo.crud.order.service;

import com.example.demo.crud.order.domain.Order;
import com.example.demo.crud.order.repository.OrderRepository;
import com.example.demo.crud.order.service.usecase.OrderSaveUseCase;
import com.example.demo.crud.order.service.usecase.OrderSelectOneUseCase;
import com.example.demo.crud.product.domain.Product;
import com.example.demo.crud.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderSaveUseCase, OrderSelectOneUseCase {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    
    @Override
    @Transactional
    public Order save(Long productId) {
        Product product = productRepository.findProductById(productId)
                .orElseThrow(() -> new IllegalArgumentException(String.valueOf(productId)));
        
        Order order = Order.builder()
                .product(product)
                .build();
        
        return orderRepository.save(order);
    }

    @Override
    public Order findById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException(String.valueOf(orderId)));
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
