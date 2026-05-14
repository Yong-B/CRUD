package com.example.demo.crud.product.domain;

public enum ProductStatus {
    AVAILABLE("판매중"),  // 판매중
    COMPLETED("거래완료");  // 거래완료

    private final String displayName;

    // 생성자
    ProductStatus(String displayName) {
        this.displayName = displayName;
    }

    // displayName을 반환하는 메서드
    public String getDisplayName() {
        return displayName;
    }
}
