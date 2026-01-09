package com.Connectivity.order_service.repository;

import com.Connectivity.order_service.entitys.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> { }

