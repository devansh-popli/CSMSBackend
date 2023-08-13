package com.carmanagementsystem.dtos;

import com.carmanagementsystem.entities.Customer;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceRequestDto {
    private Long id;
    private LocalDate serviceDate;
    private String serviceType;
    private String status;
    private String mileage;
    private String placeOfSupply;
    private String mobileGSTNum;
    private String demandedRepairs;
    private String suggestedJob;
    private VehicleDto vehicle;
}
