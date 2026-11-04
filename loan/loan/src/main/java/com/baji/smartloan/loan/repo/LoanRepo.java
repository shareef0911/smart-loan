package com.baji.smartloan.loan.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baji.smartloan.loan.entity.LoanApplication;
import com.baji.smartloan.loan.entity.LoanStatus;

@Repository
public interface LoanRepo
extends JpaRepository<LoanApplication, Long> {

List<LoanApplication>
findByCustomerId(Long customerId);

List<LoanApplication>
findByStatus(LoanStatus status);
}

