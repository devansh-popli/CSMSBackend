package com.carmanagementsystem.repositories;

import com.carmanagementsystem.entities.Order;
import com.carmanagementsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByUser(User user);
}
