package com.techforge.dto;

import com.techforge.models.Status;
import jakarta.validation.constraints.*;

public record SubcategoryDTO(
        Integer id,

        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Code is required")
        @Pattern(
                regexp = "^[a-z0-9\\-]+$",
                message = "Code must contain only lowercase letters, numbers, and hyphens"
        )
        String code,

        @Size(min = 1, message = "Short description cannot be empty")
        String shortDescription,

        @Size(min = 1, message = "Study guide cannot be empty")
        String studyGuide,

        @NotNull(message = "Status is required")
        Status status,

        @NotNull(message = "Order is required")
        @Min(value = 1, message = "Order must be at least 1")
        Integer order,

        @NotNull(message = "Category ID is required")
        Integer categoryId
) {}
