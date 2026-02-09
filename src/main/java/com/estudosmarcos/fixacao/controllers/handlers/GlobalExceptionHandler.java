package com.estudosmarcos.fixacao.controllers.handlers;


import com.estudosmarcos.fixacao.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        // Uso do construtor inteligente que auto-popula timestamp e path, limpando o Handler
        CustomError customError = new CustomError(status, e.getMessage(), request);
        return ResponseEntity.status(status).body(customError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_CONTENT;
        String error = "Campo(s) inválido(s)";
        // ValidationError herda de CustomError, reaproveitando a lógica do pai
        ValidationError validationError = new ValidationError(status, error, request);

        for (FieldError fieldError : e.getFieldErrors()) {
            validationError.add(
                    new FieldMessage(fieldError.getField(), fieldError.getDefaultMessage())
            );
        }

        return ResponseEntity.status(status).body(validationError);
    }

}
