package com.carmanagementsystem.repositories;

import com.carmanagementsystem.entities.Category;
import com.carmanagementsystem.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {

    Page<Product> findByTitleContaining(String subTitle, Pageable pageable);

    Page<Product> findByLiveTrue(Pageable pageable);


    Page<Product> findByCategories(Category categories,Pageable pageable);
}
