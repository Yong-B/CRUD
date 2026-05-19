package com.example.demo.crud.product.domain;

public enum ProductStatus {
    AVAILABLE("판매중"), 
    DELETED("상품삭제"),
    SOLD_OUT("품절"); 

    private final String displayName;

    ProductStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
