package com.techforge.service;

import com.techforge.dto.CategoryDTO;
import com.techforge.mapper.CategoryMapper;
import com.techforge.models.Category;
import com.techforge.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public Optional<CategoryDTO> findById(int id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper::toDTO);
    }

    @Transactional
    public CategoryDTO save(CategoryDTO dto) {
        Category entity = CategoryMapper.toEntity(dto);
        Category saved = categoryRepository.save(entity);

        return  CategoryMapper.toDTO(saved);
    }

    @Transactional
    public CategoryDTO update(int id, CategoryDTO dto) {
        Category existing = categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Category Not Found"));

        existing.setName(dto.name());
        existing.setCode(dto.code());
        existing.setShortDescription(dto.shortDescription());
        existing.setStudyGuide(dto.studyGuide());
        existing.setStatus(dto.status());
        existing.setOrder(dto.order());
        existing.setIconPath(dto.iconPath());
        existing.setHtmlColorCode(dto.htmlColorCode());
        Category updated = categoryRepository.save(existing);
        return CategoryMapper.toDTO(updated);
    }

    @Transactional
    public boolean deleteById(int id) {
        if(!categoryRepository.existsById(id)) {
            return false;
        }
        categoryRepository.deleteById(id);
        return true;
    }
}