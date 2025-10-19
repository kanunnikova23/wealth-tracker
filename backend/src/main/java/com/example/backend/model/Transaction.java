package com.example.backend.model;
import java.time.LocalDate; // import the LocalDate class

import com.fasterxml.jackson.annotation.JsonBackReference;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

@Entity
@Data
@Table(name = "transactions")
@NoArgsConstructor // Adds a no-args constructor (required by JPA)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be greater than zero")
    private Double amount;

    private String description;

    @NotNull(message = "Date is required")
    private LocalDate date;

    @NotNull(message = "Type is required")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    // Many transactions belong to one category
    @ManyToOne
    @JsonBackReference   // prevents circular JSON
    @Schema(hidden = true)  // hides from Swagger
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Many transactions belong to one user
    @ManyToOne
    @JsonBackReference   // prevents circular JSON
    @Schema(hidden = true)  // hides from Swagger
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
