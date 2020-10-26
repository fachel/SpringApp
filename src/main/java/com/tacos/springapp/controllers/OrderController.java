package com.tacos.springapp.controllers;

import com.tacos.springapp.models.Order;
import com.tacos.springapp.models.User;
import com.tacos.springapp.repo.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors, @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        order.setUser(user);
        orderRepository.save(order);
        System.out.println("Processing ordering: " + order);
        log.info("Order submitted: " + order);
        return "redirect:/";
    }
}
