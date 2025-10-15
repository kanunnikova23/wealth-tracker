package com.example.backend.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.model.User;


// Marks this interface as a Spring-managed Repository (DAO layer)
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query method: find user by email
    User findByEmail(String email);
}
