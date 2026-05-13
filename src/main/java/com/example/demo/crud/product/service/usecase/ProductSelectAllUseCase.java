package com.example.demo.crud.product.service.usecase;

import com.example.demo.crud.product.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductSelectAllUseCase {
    Page<Product> findAll(Pageable pageable);
}
