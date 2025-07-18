package com.techforge.dto;

import com.techforge.models.Visibility;
import jakarta.validation.constraints.*;

public record CourseDTO(

        Integer id,

        @NotBlank(message = "Name is required")
        String name,

        @NotBlank(message = "Code is required")
        @Pattern(
                regexp = "^[a-z0-9\\-]+$",
                message = "Code must only contain lowercase letters, numbers, and hyphens"
        )
        String code,

        @NotNull(message = "Estimated completion time is required")
        @Min(value = 1, message = "Estimated completion time must be at least 1")
        @Max(value = 20, message = "Estimated completion time must be at most 20")
        Integer estimatedCompletionTime,

        @NotNull(message = "Visibility is required")
        Visibility visibility,

        @Size(min = 1, message = "Target audience cannot be empty")
        String targetAudience,

        @NotBlank(message = "Instructor name is required")
        String instructorName,

        String syllabus,

        String developedSkills,

        @NotNull(message = "Subcategory ID is required")
        Integer subcategoryId

) {}
