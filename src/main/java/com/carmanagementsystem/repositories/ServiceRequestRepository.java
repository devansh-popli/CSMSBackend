package com.carmanagementsystem.repositories;

import com.carmanagementsystem.entities.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest,Long> {
}
