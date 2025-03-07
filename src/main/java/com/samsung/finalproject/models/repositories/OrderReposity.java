package com.samsung.finalproject.models.repositories;

import com.samsung.finalproject.models.entities.Order;
import com.samsung.finalproject.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderReposity extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
