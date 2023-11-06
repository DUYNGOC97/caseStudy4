package com.codegym.casestudy4.repository;

import com.codegym.casestudy4.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
