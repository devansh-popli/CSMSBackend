package com.carmanagementsystem.services.impl;

import com.carmanagementsystem.entities.Customer;
import com.carmanagementsystem.entities.Vehicle;
import com.carmanagementsystem.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements com.carmanagementsystem.services.VehicleService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehiclesByCustomer(Long customerId) {
        Customer customer=new Customer();
        customer.setId(customerId);
        return vehicleRepository.findByCustomer(customer);
    }

    // Other service methods for CRUD operations
}

