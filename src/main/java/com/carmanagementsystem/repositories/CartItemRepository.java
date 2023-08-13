package com.carmanagementsystem.repositories;

import com.carmanagementsystem.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Integer> {
}
