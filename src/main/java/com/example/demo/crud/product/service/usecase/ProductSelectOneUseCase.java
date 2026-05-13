package com.example.demo.crud.product.service.usecase;

import com.example.demo.crud.product.domain.Product;

public interface ProductSelectOneUseCase {
    Product findById(Long id);
    
}
