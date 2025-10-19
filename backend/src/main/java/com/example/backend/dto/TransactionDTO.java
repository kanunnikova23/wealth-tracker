package com.example.backend.dto;
import com.example.backend.model.TransactionType;

import io.micrometer.common.lang.Nullable;

import java.time.LocalDate;
import jakarta.validation.constraints.*;
import lombok.*;


@Data
public class TransactionDTO {
    
    @NotNull @Positive
    private Double amount;

    @Nullable
    private String description;

    @NotNull
    private LocalDate date;

    @NotNull
    private TransactionType type;

    @NotNull
    private Long categoryId;

    @NotNull
    private Long userId;
}

    