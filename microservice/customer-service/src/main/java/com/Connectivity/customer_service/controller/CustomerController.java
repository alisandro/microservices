package com.Connectivity.customer_service.controller;

import com.Connectivity.customer_service.DTO.CustomerDTO;
import com.Connectivity.customer_service.entitys.Customer;
import com.Connectivity.customer_service.repository.CustomerRepository;
import com.Connectivity.customer_service.services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/system/customers")
public class CustomerController {

    private final CustomerService customerService;

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
        // El repositorio le asignará el ID 1 si es el primero
        Customer savedCustomer = customerRepository.save(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }
    /**Crear un nuevo cliente con validación
    @PostMapping
    public ResponseEntity<Customer> create(@Valid @RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        // Devolvemos un status 201 (Created)
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }
    **/


}
