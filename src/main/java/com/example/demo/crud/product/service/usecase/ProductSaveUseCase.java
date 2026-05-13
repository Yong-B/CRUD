package com.example.demo.crud.product.service.usecase;

import com.example.demo.crud.product.domain.Product;
import com.example.demo.crud.product.domain.dto.ProductRequestDto;

public interface ProductSaveUseCase {
    Product save(ProductRequestDto dto);
}
