package com.estudosmarcos.fixacao.controllers.handlers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomError {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;

    // Construtor "Smart" para simplificar a criação no Handler, centralizando a lógica de data e path
    public CustomError(HttpStatus status, String error, HttpServletRequest request) {
        this.timestamp = Instant.now();
        this.status = status.value();
        this.error = error;
        this.path = request.getRequestURI();
    }

}
