package com.samsung.finalproject.models.repositories;

import com.samsung.finalproject.models.entities.Cart;
import com.samsung.finalproject.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUser(User user);
}
