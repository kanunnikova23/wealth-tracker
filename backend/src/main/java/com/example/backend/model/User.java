package com.example.backend.model;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;
}
