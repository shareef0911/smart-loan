package com.baji.smartloan.customerservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baji.smartloan.customerservice.entity.Customer;
import com.baji.smartloan.customerservice.repo.CustomerRepo;

@Service
public class CustomerService {

	private final CustomerRepo repository;

    public CustomerService(CustomerRepo repository) {

        this.repository = repository;
    }

    public Customer create(Customer customer) {

        return repository.save(customer);
    }

    public Customer getById(Long id) {

        return repository.findById(id)
                .orElseThrow(
                    () -> new RuntimeException(
                        "Customer not found"));
    }

    public List<Customer> getAll() {

        return repository.findAll();
    }

    public Customer update(
            Long id,
            Customer customer) {

        Customer existing = getById(id);

        existing.setName(customer.getName());

        existing.setEmail(customer.getEmail());

        existing.setPhone(customer.getPhone());

        existing.setMonthlySalary(
                customer.getMonthlySalary());

        existing.setEmploymentType(
                customer.getEmploymentType());

        existing.setCompany(
                customer.getCompany());

        existing.setExperience(
                customer.getExperience());

        existing.setCreditScore(
                customer.getCreditScore());

        return repository.save(existing);
    }

    public void delete(Long id) {

        repository.deleteById(id);
    }

}
