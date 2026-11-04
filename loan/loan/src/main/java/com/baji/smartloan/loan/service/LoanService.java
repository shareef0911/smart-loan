package com.baji.smartloan.loan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baji.smartloan.loan.entity.LoanApplication;
import com.baji.smartloan.loan.entity.LoanStatus;
import com.baji.smartloan.loan.repo.LoanRepo;


@Service
public class LoanService {

    private final LoanRepo repository;

    public LoanService(LoanRepo repository) {

        this.repository = repository;
    }

    public LoanApplication apply(
            LoanApplication loan) {

        loan.setStatus(LoanStatus.PENDING);

        return repository.save(loan);
    }

    public LoanApplication getById(Long id) {

        return repository.findById(id)
                .orElseThrow(
                    () -> new RuntimeException(
                        "Loan application not found"));
    }

    public List<LoanApplication>
        getByCustomer(Long customerId) {

        return repository
                .findByCustomerId(customerId);
    }

    public LoanApplication approve(Long id) {

        LoanApplication loan = getById(id);

        loan.setStatus(LoanStatus.APPROVED);

        return repository.save(loan);
    }

    public LoanApplication reject(Long id) {

        LoanApplication loan = getById(id);

        loan.setStatus(LoanStatus.REJECTED);

        return repository.save(loan);
    }
}

