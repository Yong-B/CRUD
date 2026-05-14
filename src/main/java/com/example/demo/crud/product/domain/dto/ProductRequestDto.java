package com.example.demo.crud.product.domain.dto;

import com.example.demo.crud.product.domain.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class ProductRequestDto {

    @NotBlank(message = "상품명은 필수입니다.")
    @Size(max = 50, message = "상품명은 50자 이하여야 합니다.")
    private String name;

    @NotBlank(message = "상품 설명은 필수입니다.")
    @Size(max = 500, message = "상품 설명은 500자 이하여야 합니다.")
    private String description;

    @NotNull(message = "가격은 필수입니다.")
    @Min(value = 0, message = "가격은 0원 이상이어야 합니다.")
    private Integer price;

    public Product toEntity() {
        return Product.builder()
                .name(this.name)
                .description(this.description)
                .price(this.price)
                .build();
    }
}