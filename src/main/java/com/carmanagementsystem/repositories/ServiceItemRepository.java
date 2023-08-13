package com.carmanagementsystem.repositories;

import com.carmanagementsystem.entities.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceItemRepository extends JpaRepository<Services,Long> {
}
