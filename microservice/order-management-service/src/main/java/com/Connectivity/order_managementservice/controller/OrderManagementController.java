package com.Connectivity.order_managementservice.controller;

import com.Connectivity.order_managementservice.DTO.CustomerDTO;
import com.Connectivity.order_managementservice.DTO.OrderDTO;
import com.Connectivity.order_managementservice.services.OrderManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/process/")
@RequiredArgsConstructor
public class OrderManagementController {

    private final OrderManagementService orderManagementService;

    @PostMapping("/checkout")
    public ResponseEntity<String> checkout(@RequestBody OrderDTO request) {
        // Pasamos el objeto 'request' completo al service
        String response = orderManagementService.createProcessedOrder(request);
        return ResponseEntity.ok(response);
    }
}