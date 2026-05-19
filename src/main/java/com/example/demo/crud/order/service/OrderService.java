package com.example.demo.crud.order.service;

import com.example.demo.crud.order.domain.Order;
import com.example.demo.crud.order.repository.OrderRepository;
import com.example.demo.crud.order.service.usecase.OrderSaveUseCase;
import com.example.demo.crud.order.service.usecase.OrderSelectAllUseCase;
import com.example.demo.crud.order.service.usecase.OrderSelectOneUseCase;
import com.example.demo.crud.product.domain.Product;
import com.example.demo.crud.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderSaveUseCase, OrderSelectOneUseCase, OrderSelectAllUseCase{

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    
    @Override
    @Transactional
    public Order save(Long productId) {
        Product product = productRepository.findByIdWithLock(productId)
                .orElseThrow(() -> new IllegalArgumentException(String.valueOf(productId)));
        
        product.decreaseStock();
        
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
    @Transactional(readOnly = true)
    public Page<Order> findAll(Pageable pageable) {
        return orderRepository.findAllWithProduct(pageable);
    }
}
