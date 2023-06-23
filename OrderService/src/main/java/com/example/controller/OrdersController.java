package com.example.controller;

import com.example.model.OrderDTO;
import com.example.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addOrder(@RequestBody OrderDTO orderDTO) {
        ordersService.addOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
