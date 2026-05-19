package com.example.demo.crud.product.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "stock", nullable = false)
    private int stock;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 50)
    private ProductStatus status = ProductStatus.AVAILABLE;

    @CreatedDate
    @Column(name = "created_at", updatable = false, columnDefinition = "TIMESTAMP DEFAULT NOW()")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    private Product(String name, int price, int stock, String description, ProductStatus status) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.status = (status != null) ? status : ProductStatus.AVAILABLE; // String -> Enum
    }

    public void updateInfo(String name, int price, int stock, String description) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }

    public void delete() {
        this.status = ProductStatus.DELETED; 
    }
    
    public void decreaseStock() {
        if (this.stock <= 0) {
            throw new IllegalStateException("재고가 부족합니다.");
        }

        this.stock -= 1;

        if (this.stock == 0) {
            this.status = ProductStatus.SOLD_OUT;
        }
    }
}

