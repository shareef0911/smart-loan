package com.baji.smartloan.customerservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.baji.smartloan.customerservice.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long>{

}
