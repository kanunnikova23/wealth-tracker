package com.example.backend.dto;

import com.example.backend.model.TransactionType;
import jakarta.validation.constraints.*;
import lombok.Data;
import jakarta.annotation.Nullable;

@Data
public class CategoryDTO {
    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Type is required")
    private TransactionType type;

    @Nullable
    private String description;

    @NotNull(message = "User ID is required")
    private Long userId;
}
