# microservices
📌 System API: customer-service y order-service 📌 Process API: order-management-service 📌 Experience API: gateway-service (usando Spring Cloud Gateway)

test directos desde vscode

### Petición al Gateway para procesar una orden
POST http://localhost:9000/api/v1/process/checkout
Content-Type: application/json

{
    "customerId": 14,
    "total": 1250.50
}

### Petición al Gateway (Puerto 9000) alta ciente

POST http://localhost:8081/api/v1/system/customers
Content-Type: application/json

{
    "firstName": "alisandro",
    "lastName": "ms",
    "email": "ms.ali@gmail.com"
}

