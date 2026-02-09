package com.estudosmarcos.fixacao.controllers.handlers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError extends CustomError {

    private final List<FieldMessage> fieldMessages = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public ValidationError(HttpStatus status, String error, HttpServletRequest request) {
        super(status, error, request);
    }

    public void add(FieldMessage f) {
        fieldMessages.add(f);
    }
}
