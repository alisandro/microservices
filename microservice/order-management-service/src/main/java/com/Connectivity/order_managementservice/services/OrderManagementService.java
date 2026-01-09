package com.Connectivity.order_managementservice.services;

import com.Connectivity.order_managementservice.DTO.CustomerDTO;
import com.Connectivity.order_managementservice.DTO.OrderDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderManagementService {

    private final RestTemplate restTemplate;

    // Definimos las URLs de las System APIs (idealmente vendrían de un application.yml)
    private final String CUSTOMER_SERVICE_URL = "http://localhost:8081/api/v1/system/customers/";
    private final String ORDER_SERVICE_URL = "http://localhost:8082/api/v1/system/orders";

    public OrderManagementService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String createProcessedOrder(OrderDTO orderDTO) {
        try {
            // 1. Llamada al servicio de clientes (8081)
            String customerUrl = "http://localhost:8081/api/v1/system/customers/" + orderDTO.getCustomerId();

            // Obtenemos el cliente
            CustomerDTO customer = restTemplate.getForObject(customerUrl, CustomerDTO.class);

            // 2. Validación de seguridad
            if (customer == null) {
                return "Error: El servicio de clientes no devolvió información para el ID: " + orderDTO.getCustomerId();
            }


            return "Orden procesada con éxito. Cliente: " + customer.getName() + " | Total: " + orderDTO.getTotal();

        } catch (Exception e) {
            // Si el cliente no existe o el 8081 está caído, atrapamos el error aquí
            return "No se pudo procesar la orden: El cliente con ID " + orderDTO.getCustomerId() + " no existe o el sistema está fuera de línea.";
        }
    }
}