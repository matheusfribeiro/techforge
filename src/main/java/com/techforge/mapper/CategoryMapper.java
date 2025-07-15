package com.techforge.mapper;

import com.techforge.dto.CategoryDTO;
import com.techforge.models.Category;

public class CategoryMapper {

    public static CategoryDTO toDTO(Category category) {
        return new CategoryDTO(
                category.getId(),
                category.getName(),
                category.getCode(),
                category.getShortDescription(),
                category.getStudyGuide(),
                category.getStatus(),
                category.getOrder(),
                category.getIconPath(),
                category.getHtmlColorCode()
        );
    }

    public static Category toEntity(CategoryDTO dto) {
        return new Category(
                dto.id() != null ? dto.id() : 0,
                dto.name(),
                dto.code(),
                dto.shortDescription(),
                dto.studyGuide(),
                dto.status(),
                dto.order(),
                dto.iconPath(),
                dto.htmlColorCode()
        );
    }

}
