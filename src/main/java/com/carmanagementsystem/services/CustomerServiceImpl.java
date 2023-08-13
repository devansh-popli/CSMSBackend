package com.carmanagementsystem.services;

import com.carmanagementsystem.entities.Customer;
import com.carmanagementsystem.entities.CustomerDto;
import com.carmanagementsystem.exceptions.ResourceNotFoundException;
import com.carmanagementsystem.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<CustomerDto> getAllCustomers() {
       List<Customer> customers= customerRepository.findAll();
     return  customers.stream().map(customer -> {
           return modelMapper.map(customer,CustomerDto.class);
       }).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(Long customerId) {
        return modelMapper.map(customerRepository.findById(customerId).orElseThrow(()->new ResourceNotFoundException(("Customer Not Found"))),CustomerDto.class);
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customer) {
Customer customer1=modelMapper.map(customer,Customer.class);
        return modelMapper.map(customerRepository.save(customer1),CustomerDto.class);
    }

    @Override
    public List<CustomerDto> getAllCustomersBySearch(String search) {
        List<Customer> customers= customerRepository.findByCustomerNameContaining(search);
        return  customers.stream().map(customer -> {
            return modelMapper.map(customer,CustomerDto.class);
        }).collect(Collectors.toList());
    }

    // Other service methods for CRUD operations
}
