package com.example.backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;;

// Marks this class as a database entity (table)
@Entity  
// Generates getters, setters, equals, hashCode, toString automatically
@Data  
// Adds a no-args constructor (required by JPA)
@NoArgsConstructor  
// Binds this entity to a specific table name in the database
@Table(name = "users")  

public class User {
    // Marks this field as the primary key (unique identifier)
    @Id
    // Specifies that the ID should be generated automatically
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Marks this field as a column in the database table
    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(nullable = false, unique = true)
    private String email;

    // A user can have many categories
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(hidden = true)
    @JsonManagedReference
    private List<Category> categories;

    // A user can have many transactions
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(hidden = true)
    @JsonManagedReference
    private List<Transaction> transactions;
}
