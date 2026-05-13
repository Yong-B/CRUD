package com.example.demo.crud.product.service;

import com.example.demo.crud.product.domain.Product;
import com.example.demo.crud.product.domain.ProductStatus;
import com.example.demo.crud.product.domain.dto.ProductRequestDto;
import com.example.demo.crud.product.repository.ProductRepository;
import com.example.demo.crud.product.service.usecase.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductSelectAllUseCase, ProductSaveUseCase, ProductSelectOneUseCase, ProductUpdateUseCase, ProductDeleteUseCase {
    private final ProductRepository productRepository;
    
    @Override
    @Transactional
    public Product save(ProductRequestDto dto) {
        return productRepository.save(dto.toEntity());
    }
    
    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Item not found with id: " + id));
    }

    @Transactional
    @Override
    public Product update(Long itemId, ProductRequestDto updateParam) {
        Product findItem = findById(itemId);
        findItem.updateInfo(
                updateParam.getName(),
                updateParam.getPrice(),
                updateParam.getDescription()
        );

        return productRepository.save(findItem);
    }

    @Override
    public void delete(Long productId) {
        Product findItem = findById(productId);
        productRepository.delete(findItem);
    }
}
