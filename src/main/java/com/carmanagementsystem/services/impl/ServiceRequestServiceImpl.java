package com.carmanagementsystem.services.impl;

import com.carmanagementsystem.dtos.ServiceRequestDto;
import com.carmanagementsystem.entities.ServiceRequest;
import com.carmanagementsystem.repositories.ServiceRequestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceRequestServiceImpl implements com.carmanagementsystem.services.ServiceRequestService {
    @Autowired
    private ServiceRequestRepository serviceRequestRepository;
@Autowired
private ModelMapper modelMapper;
    @Override
    public List<ServiceRequestDto> getAllServiceRequests() {
        List<ServiceRequest> serviceRequests=serviceRequestRepository.findAll();
       return  serviceRequests.stream().map(servicereq->{
           return modelMapper.map(servicereq,ServiceRequestDto.class);
       }).collect(Collectors.toList());
    }

    @Override
    public ServiceRequestDto createServiceRequest(ServiceRequest serviceRequest) {
        serviceRequest.getServiceItems().forEach(services ->{
            services.setServiceRequest(serviceRequest);
        } );
        return modelMapper.map(serviceRequestRepository.save(serviceRequest),ServiceRequestDto.class);
    }

    // Other service methods for CRUD operations
}

