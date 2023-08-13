package com.carmanagementsystem.entities;

import com.carmanagementsystem.dtos.ServiceRequestDto;
import com.carmanagementsystem.dtos.VehicleDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDto {
    private Long id;
    @NotBlank
    private String customerName;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private String address;
    @NotBlank
    private String pin;
    @NotBlank
    private String state;
    private String code;
    private List<ServiceRequestDto> serviceRequests;
    private List<VehicleDto> vehicles;
}
