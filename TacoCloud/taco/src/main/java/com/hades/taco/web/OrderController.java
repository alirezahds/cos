package com.hades.taco.web;

import javax.validation.Valid;

import com.hades.taco.Order;
import com.hades.taco.data.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/order")
@SessionAttributes("order")
public class OrderController {

    OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @ModelAttribute("order")
    public Order order() {
        return new Order();
    }

    @GetMapping
    public String showOrderForm() {
        return "order";
    }

    @PostMapping
    public String processOrderForm(@Valid Order order, Errors Errors, SessionStatus sessionStatus) {

        if (Errors.hasErrors()) {
            return "order";
        }

        orderRepository.save(order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}
