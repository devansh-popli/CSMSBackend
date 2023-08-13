package com.carmanagementsystem.controller;

import com.carmanagementsystem.entities.Customer;
import com.carmanagementsystem.entities.CustomerDto;
import com.carmanagementsystem.repositories.CustomerRepository;
import com.carmanagementsystem.repositories.ServiceRequestRepository;
import com.carmanagementsystem.repositories.VehicleRepository;
import com.carmanagementsystem.services.CustomerService;
import com.google.j2objc.annotations.AutoreleasePool;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ServiceRequestRepository serviceRequestRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    // ... other methods

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        if (!customerOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Customer customer = customerOptional.get();

        // Delete associated service requests
        serviceRequestRepository.deleteAll(customer.getServiceRequests());

        // Delete associated vehicles
        vehicleRepository.deleteAll(customer.getVehicles());

        // Delete the customer
        customerRepository.deleteById(customerId);
        return ResponseEntity.ok("Customer deleted successfully");
    }
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    @GetMapping("/search/{search}")
    public ResponseEntity<List<CustomerDto>> getAllCustomersBySearch(@PathVariable String search) {
        return ResponseEntity.ok(customerService.getAllCustomersBySearch(search));
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long customerId) {
        CustomerDto customer = customerService.getCustomerById(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody @Valid CustomerDto customer) {
        CustomerDto createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    // Other CRUD operations and endpoints
}

