package com.Connectivity.order_managementservice.exceptions;

import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class RestTemplateErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().isError();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().is4xxClientError()) {
            // Manejar errores como "Producto no encontrado" o "Saldo insuficiente"
            throw new HttpClientErrorException(response.getStatusCode(), "Error de validación en servicio externo");
        } else if (response.getStatusCode().is5xxServerError()) {
            // Manejar errores de servidor (caídas de DB externa, etc)
            throw new HttpServerErrorException(response.getStatusCode(), "El servicio externo falló");
        }
    }
}