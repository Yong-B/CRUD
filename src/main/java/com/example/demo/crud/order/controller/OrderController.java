package com.example.demo.crud.order.controller;

import com.example.demo.crud.order.domain.Order;
import com.example.demo.crud.order.service.usecase.OrderSaveUseCase;
import com.example.demo.crud.order.service.usecase.OrderSelectAllUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderSaveUseCase orderSaveUseCase;
    private final OrderSelectAllUseCase orderSelectAllUseCase;

    @PostMapping("/item/products/{productId}/order")
    public String order(@PathVariable Long productId) {
        Order order = orderSaveUseCase.save(productId);
        return "redirect:/item/products";
    }

    @GetMapping("/orders")
    public String orderList(Model model,
                            @PageableDefault(size = 10, sort = "id") Pageable pageable) {
        Page<Order> orders = orderSelectAllUseCase.findAll(pageable);
        model.addAttribute("orders", orders);
        return "item/orders"; // templates/order/order-list.html
    }

}
