package com.carmanagementsystem.repositories;

import com.carmanagementsystem.entities.Customer;
import com.carmanagementsystem.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    List<Vehicle> findByCustomer(Customer customer);
}
