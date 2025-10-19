package com.example.backend.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserDTO {

    @NotBlank(message = "Name is required") @Size(min = 2, max = 100)
    private String name;

    @NotBlank(message = "Email is required") @Email(message = "Invalid email format")
    private String email;
}
