package com.estudosmarcos.fixacao.controllers;


import com.estudosmarcos.fixacao.dto.DashboardDTO;
import com.estudosmarcos.fixacao.services.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService service;

    @GetMapping
    public ResponseEntity<DashboardDTO> generate(@RequestParam(required = false) Integer month,
                                                 @RequestParam(required = false) Integer year) {
        return ResponseEntity.ok(service.generate(month, year));

    }


}
