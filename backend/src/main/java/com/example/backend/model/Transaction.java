package com.example.backend.model;
import java.time.LocalDate; // import the LocalDate class

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "transactions")
@NoArgsConstructor // Adds a no-args constructor (required by JPA)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private String description;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    // Many transactions belong to one category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Many transactions belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
