package com.baji.smartloan.loan.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baji.smartloan.loan.entity.LoanApplication;
import com.baji.smartloan.loan.service.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService service;

    public LoanController(LoanService service) {

        this.service = service;
    }

    @PostMapping("/apply")
    public LoanApplication apply(
            @RequestBody LoanApplication loan) {

        return service.apply(loan);
    }

    @GetMapping("/{id}")
    public LoanApplication getById(
            @PathVariable Long id) {

        return service.getById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<LoanApplication>
        getByCustomer(
            @PathVariable Long customerId) {

        return service.getByCustomer(customerId);
    }

    @PutMapping("/{id}/approve")
    public LoanApplication approve(
            @PathVariable Long id) {

        return service.approve(id);
    }

    @PutMapping("/{id}/reject")
    public LoanApplication reject(
            @PathVariable Long id) {

        return service.reject(id);
    }
}

