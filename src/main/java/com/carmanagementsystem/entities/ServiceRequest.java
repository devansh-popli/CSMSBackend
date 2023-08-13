package com.carmanagementsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private LocalDate serviceDate;
    private String serviceType;
    private String status;
    private String mileage;
    private String placeOfSupply;
    private String mobileGSTNum;
    private String demandedRepairs;
    private String suggestedJob;
    @ManyToOne
    @JoinColumn(name="vehicle_id")
    private Vehicle vehicle;
    @OneToMany(mappedBy = "serviceRequest", cascade = CascadeType.ALL)
    private List<Services> serviceItems;
    private Long gst;
    private Long tax;
    private Long totalAmount;
}
