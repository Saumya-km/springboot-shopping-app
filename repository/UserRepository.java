package com.example.shoppingapp.repository;

import com.example.shoppingapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query method
    User findByUsername(String username);

    // You can add more: e.g.
    // User findByEmail(String email);
}
