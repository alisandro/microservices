package com.Connectivity.customer_service.DTO;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor  // Fundamental para que Jackson (RestTemplate) pueda crear el objeto
@AllArgsConstructor // Necesario para que el Builder funcione
public class CustomerDTO {

    private Long id;
    private String name;  // Aquí uniremos firstName + lastName del System API
    private String email;
}