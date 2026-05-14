package com.example.demo.crud.order.controller;

import com.example.demo.crud.order.domain.Order;
import com.example.demo.crud.order.service.usecase.OrderSaveUseCase;
import com.example.demo.crud.order.service.usecase.OrderSelectOneUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderSaveUseCase orderSaveUseCase;
    private final OrderSelectOneUseCase orderSelectOneUseCase;

    @PostMapping("/item/products/{productId}/order")
    public String order(@PathVariable Long productId) {
        Order order = orderSaveUseCase.save(productId);
        return "redirect:/item/products";
    }

    @GetMapping("/orders")
    public String orderList(Model model) {
        List<Order> orders = orderSelectOneUseCase.findAll();
        model.addAttribute("orders", orders);
        return "item/orders"; // templates/order/order-list.html
    }
    
}
