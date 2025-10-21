package com.example.backend.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.model.User;
import java.util.Optional;


// Marks this interface as a Spring-managed Repository (DAO layer)
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Optionally find a user by their email
    Optional<User> findByEmail(String email);
}
