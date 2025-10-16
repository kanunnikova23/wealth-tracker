package com.example.backend.model;
import java.time.LocalDateTime; // import the LocalDateTime class

import jakarta.persistence.*;
import lombok.*;
import java.util.List;


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
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    private String description;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Many categories belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // One category can have many transactions
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions;
}
