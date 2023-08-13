package com.carmanagementsystem.services;

import com.carmanagementsystem.entities.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllVehicles();

    Vehicle createVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehiclesByCustomer(Long customerId);
}
