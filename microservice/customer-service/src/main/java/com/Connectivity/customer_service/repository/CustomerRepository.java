package com.Connectivity.customer_service.repository;

import com.Connectivity.customer_service.entitys.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> { }
