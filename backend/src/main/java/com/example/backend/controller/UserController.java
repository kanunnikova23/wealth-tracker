package com.example.backend.controller;

import com.example.backend.model.User;
import com.example.backend.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Marks this class as a REST controller (returns JSON responses)
@RestController
// Base URL for all endpoints in this controller
@RequestMapping("/api/users")
// Allows cross-origin requests from any domain (for development purposes)  
@CrossOrigin(origins = "*")
// Controller class to handle HTTP requests related to User entity
public class UserController {
    private final UserService userService;

    // Constructor for UserController with dependency injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint to retrieve all users
    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    // Endpoint to create a new user
    @PostMapping
    public User create(@RequestBody User user) {
        return userService.create(user);
    }

    // Endpoint to retrieve a user by ID
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }
    
    // Endpoint to delete a user by ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
