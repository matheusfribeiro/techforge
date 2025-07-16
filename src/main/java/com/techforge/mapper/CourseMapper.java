package com.techforge.mapper;

import com.techforge.dto.CourseDTO;
import com.techforge.models.Course;
import com.techforge.models.Subcategory;
import com.techforge.repository.SubcategoryRepository;

public class CourseMapper {

    public static CourseDTO toDTO(Course course) {
        return new CourseDTO(
                course.getId(),
                course.getName(),
                course.getCode(),
                course.getEstimatedCompletionTime(),
                course.getVisibility(),
                course.getTargetAudience(),
                course.getInstructorName(),
                course.getSyllabus(),
                course.getDevelopedSkills(),
                course.getSubcategory() != null ? course.getSubcategory().getId() : null
        );
    }

    public static Course toEntity(CourseDTO dto, SubcategoryRepository subcategoryRepo) {
        Subcategory sub = subcategoryRepo.findById(dto.subcategoryId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "subcategory not found with this id " + dto.subcategoryId()
                ));

        return new Course(
                dto.id() != null ? dto.id() : 0,
                dto.name(),
                dto.code(),
                dto.estimatedCompletionTime(),
                dto.visibility(),
                dto.targetAudience(),
                dto.instructorName(),
                dto.syllabus(),
                dto.developedSkills(),
                sub
        );
    }
}
