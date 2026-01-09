package com.Connectivity.order_service.controller;

import com.Connectivity.order_service.DTO.OrderDTO;
import com.Connectivity.order_service.entitys.Order;
import com.Connectivity.order_service.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/system/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTO orderDTO) {
        // Lógica para guardar en la base de datos de órdenes
        return ResponseEntity.status(HttpStatus.CREATED).body(orderDTO);
    }


}
