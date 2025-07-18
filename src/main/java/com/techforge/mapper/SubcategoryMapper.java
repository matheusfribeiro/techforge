package com.techforge.mapper;

import com.techforge.dto.SubcategoryDTO;
import com.techforge.models.Category;
import com.techforge.models.Subcategory;
import com.techforge.repository.CategoryRepository;

public class SubcategoryMapper {

    public static SubcategoryDTO toDTO(Subcategory subcategory) {
        return new SubcategoryDTO(
                subcategory.getId(),
                subcategory.getName(),
                subcategory.getCode(),
                subcategory.getShortDescription(),
                subcategory.getStudyGuide(),
                subcategory.getStatus(),
                subcategory.getOrder(),
                subcategory.getCategory().getId()
        );
    }

    public static Subcategory toEntity(
            SubcategoryDTO dto,
            CategoryRepository categoryRepository
    ) {
        Category category = categoryRepository.findById(dto.categoryId()).orElseThrow(() -> new IllegalArgumentException(
                "Category not found with this id" + dto.categoryId()
        ));

        return new Subcategory(
                dto.id() != null ? dto.id() : 0,
                dto.name(),
                dto.code(),
                dto.shortDescription(),
                dto.studyGuide(),
                dto.status(),
                dto.order(),
                category
        );
    }
}
