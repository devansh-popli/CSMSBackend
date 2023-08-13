package com.carmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
@Column(unique = true)
    private String regNo;
    private String carModel;
    @Column(unique = true)
    private String chasisNo;
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<ServiceRequest> serviceRequests;
    // Other fields and relationships
}
