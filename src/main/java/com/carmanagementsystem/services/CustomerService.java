package com.carmanagementsystem.services;

import com.carmanagementsystem.entities.Customer;
import com.carmanagementsystem.entities.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();
    CustomerDto getCustomerById(Long customerId);
    CustomerDto createCustomer(CustomerDto customer);

    List<CustomerDto>  getAllCustomersBySearch(String search);
}
