package com.carmanagementsystem.repositories;

import com.carmanagementsystem.entities.Cart;
import com.carmanagementsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,String> {
    Optional<Cart> findByUser(User user);
}
