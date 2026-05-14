package com.example.demo.crud.product.domain;

public enum ProductStatus {
    AVAILABLE("판매중"),  // 판매중
    DELETED("상품삭제"),
    SOLE_OUT("품절");  // 거래완료

    private final String displayName;

    ProductStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
