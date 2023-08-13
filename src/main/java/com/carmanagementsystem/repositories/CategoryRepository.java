package com.carmanagementsystem.repositories;

import com.carmanagementsystem.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {
}
