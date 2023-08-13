package com.carmanagementsystem.repositories;

import com.carmanagementsystem.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByCustomerNameContaining(String search);
}
