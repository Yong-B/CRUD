package com.example.demo.crud.product.controller;

import com.example.demo.crud.product.domain.Product;
import com.example.demo.crud.product.domain.dto.ProductRequestDto;
import com.example.demo.crud.product.service.usecase.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/item/products")
public class ProductController {
    private final ProductSaveUseCase productSaveUseCase;
    private final ProductSelectAllUseCase productSelectAllUseCase;
    private final ProductSelectOneUseCase productSelectOneUseCase;
    private final ProductUpdateUseCase productUpdateUseCase;
    private final ProductDeleteUseCase productDeleteUseCase;

    @GetMapping // 목록 조회
    public String products(Model model,
                           @PageableDefault(page = 0, size = 30, sort = "id", direction = Direction.ASC) Pageable pageable,
                           String searchKeyword) {
        Page<Product> products;
        products = productSelectAllUseCase.findAll(pageable);
        model.addAttribute("products", products);
        return "item/products";
    }

    //상품 등록
    @PostMapping("/add")
    public String save(@ModelAttribute @Valid ProductRequestDto dto,
                       BindingResult bindingResult, Model model) {

        // 1. 검증 오류 발생 시 로그 출력 (콘솔에서 확인 가능)
        if (bindingResult.hasErrors()) {
            return "item/addForm";
        }
        productSaveUseCase.save(dto);
        return "redirect:/item/products";
    }

    @GetMapping("/add")
    public String addForm() {

        return "item/addForm";
    }

    //상세 조회
    @GetMapping("/{productId}")
    public String detail(@PathVariable Long productId, Model model) {
        Product product = productSelectOneUseCase.findById(productId);
        model.addAttribute("product", product);
        return "item/detail";
    }

    //상품 수정
    @GetMapping("/{productId}/edit")
    public String editForm(@PathVariable Long productId, Model model) {
        Product product = productSelectOneUseCase.findById(productId);
        model.addAttribute("product", product);
        return "item/editForm";
    }
    
    @PostMapping("/{productId}/edit")
    public String edit(@PathVariable Long productId, @ModelAttribute ProductRequestDto dto) {
        productUpdateUseCase.update(productId, dto);
        return "redirect:/item/products/{productId}";
    }
    
    //상품 삭제
    @GetMapping("/{productId}/delete")
    public String delete(@PathVariable Long productId) {
        productDeleteUseCase.delete(productId);
        return "redirect:/item/products";
    }
}
