package com.example.backend.model;
import java.time.LocalDateTime; // import the LocalDateTime class

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;;


@Entity // Marks this class as a database entity (table)
@Data // Generates getters, setters, equals, hashCode, toString automatically
@Table(name = "categories") // Binds this entity to a specific table name in the database
@NoArgsConstructor // Adds a no-args constructor (required by JPA)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    // Enum type for category type (INCOME or EXPENSE)
    @NotNull(message = "Type cannot be null")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Nullable
    private String description;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Many categories belong to one user
    @ManyToOne
    @Schema(hidden = true)
    @JsonBackReference
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // One category can have many transactions
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @Schema(hidden = true)
    @JsonManagedReference
    private List<Transaction> transactions;
}
