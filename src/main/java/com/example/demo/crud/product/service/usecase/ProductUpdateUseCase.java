package com.example.demo.crud.product.service.usecase;

import com.example.demo.crud.product.domain.Product;
import com.example.demo.crud.product.domain.ProductStatus;
import com.example.demo.crud.product.domain.dto.ProductRequestDto;

import java.awt.*;

public interface ProductUpdateUseCase {
    Product update(Long productId, ProductRequestDto updateParam);

    /*void updateStatus(Long productId, ProductStatus status);*/
}
