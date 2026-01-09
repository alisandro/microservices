package com.Connectivity.customer_service.services;

import com.Connectivity.customer_service.DTO.CustomerDTO;
import com.Connectivity.customer_service.entitys.Customer;
import com.Connectivity.customer_service.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerDTO getCustomerById(Long id) {
        // Buscamos la entidad en la DB
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));

        // Mapeamos de Entidad a DTO
        return CustomerDTO.builder()
                .id(customer.getId())
                .name(customer.getFirstName() + " " + customer.getLastName()) // Unimos los campos
                .email(customer.getEmail())
                .build();
    }


    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    public Optional<Customer> finByid(Long id) {
        return customerRepository.findById(id);
    }
}
