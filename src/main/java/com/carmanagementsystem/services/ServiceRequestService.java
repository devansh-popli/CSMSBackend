package com.carmanagementsystem.services;

import com.carmanagementsystem.dtos.ServiceRequestDto;
import com.carmanagementsystem.entities.ServiceRequest;

import java.util.List;

public interface ServiceRequestService {
    List<ServiceRequestDto> getAllServiceRequests();

    ServiceRequestDto createServiceRequest(ServiceRequest serviceRequest);
}
