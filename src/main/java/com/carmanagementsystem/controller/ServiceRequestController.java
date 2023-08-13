package com.carmanagementsystem.controller;

import com.carmanagementsystem.dtos.ServiceRequestDto;
import com.carmanagementsystem.entities.ServiceRequest;
import com.carmanagementsystem.repositories.ServiceRequestRepository;
import com.carmanagementsystem.services.ServiceRequestService;
import com.carmanagementsystem.services.impl.InvoiceGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-requests")
public class ServiceRequestController {
    @Autowired
    private ServiceRequestService serviceRequestService;
    @Autowired
    private InvoiceGenerator invoiceService;
    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @GetMapping
    public List<ServiceRequestDto> getAllServiceRequests() {
        return serviceRequestService.getAllServiceRequests();
    }

    @PostMapping
    public ResponseEntity<ServiceRequestDto> createServiceRequest(@RequestBody ServiceRequest serviceRequest) {
        ServiceRequestDto createdServiceRequest = serviceRequestService.createServiceRequest(serviceRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdServiceRequest);
    }
    @GetMapping("/{serviceRequestId}")
    public ResponseEntity<?> generateInvoice(@PathVariable Long serviceRequestId) {
        try {
            ServiceRequest serviceRequest = serviceRequestRepository.findById(serviceRequestId)
                    .orElseThrow(() -> new IllegalArgumentException("Service request not found"));

            byte[] invoiceBytes = invoiceService.generateInvoicePdf(serviceRequest);
            if (invoiceBytes != null) {
                return ResponseEntity.ok()
                        .header("Content-Disposition", "attachment; filename=invoice.pdf")
                        .contentType(MediaType.APPLICATION_PDF)
                        .body(invoiceBytes);
            } else {
                return ResponseEntity.badRequest().body("Error generating invoice");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error generating invoice");
        }
    }
    // Other CRUD operations and endpoints
}

