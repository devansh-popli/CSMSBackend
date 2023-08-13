package com.carmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    private String address;
    private String pin;
    private String state;
    private String code;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @OrderBy("serviceDate DESC")
    private List<ServiceRequest> serviceRequests;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Vehicle> vehicles;

    // Getters, setters, constructors, and other methods
}

//    private String jobCard;
//    private String mileage;
//    private String serviceType;
//    private String placeOfSupply;
//    private String mobileGSTNum;
//    private String demandedRepairs;
//    private String suggestedJob;
