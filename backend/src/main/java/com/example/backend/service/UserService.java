package com.example.backend.service;

import org.springframework.stereotype.Service;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import java.util.List;

// Marks this class as a service component (business logic layer)
@Service
public class UserService {
    private final UserRepository userRepository;

    // Constructor for UserService with dependency injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Retrieves all users from the database
    public List<User> getAll() {
        return userRepository.findAll();
    }

    // Creates a new user in the database
    public User create(User user) {
        return userRepository.save(user);
    }

    // Retrieves a user by ID from the database
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Deletes a user by ID from the database
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}