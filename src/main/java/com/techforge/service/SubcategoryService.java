package com.techforge.service;

import com.techforge.dto.SubcategoryDTO;
import com.techforge.mapper.SubcategoryMapper;
import com.techforge.models.Category;
import com.techforge.models.Subcategory;
import com.techforge.repository.CategoryRepository;
import com.techforge.repository.SubcategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;
    private final CategoryRepository categoryRepository;

    public SubcategoryService(SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<SubcategoryDTO> findAll() {
        return subcategoryRepository.findAll().stream().map(SubcategoryMapper::toDTO).toList();
    }

    @Transactional(readOnly = true)
    public Optional<SubcategoryDTO> findById(int id) {
        return subcategoryRepository.findById(id).map(SubcategoryMapper::toDTO);
    }

    @Transactional
    public SubcategoryDTO save(SubcategoryDTO dto) {
        Subcategory entity = SubcategoryMapper.toEntity(dto, categoryRepository);
        Subcategory saved =  subcategoryRepository.save(entity);
        return SubcategoryMapper.toDTO(saved);
    }

    @Transactional
    public SubcategoryDTO update(int id, SubcategoryDTO dto) {
        Subcategory existing = subcategoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("SUbcategory not found"));
        existing.setName(dto.name());
        existing.setCode(dto.code());
        existing.setShortDescription(dto.shortDescription());
        existing.setStudyGuide(dto.studyGuide());
        existing.setStatus(dto.status());
        existing.setOrder(dto.order());
        Category category = categoryRepository.findById(dto.categoryId()).orElseThrow(() -> new IllegalArgumentException("Category not found with this id"));
        existing.setCategory(category);

        Subcategory updated = subcategoryRepository.save(existing);
        return SubcategoryMapper.toDTO(updated);
    }

    @Transactional
    public boolean deleteById(int id) {
        if (!subcategoryRepository.existsById(id)) {
            return false;
        }
        subcategoryRepository.deleteById(id);
        return true;
    }
}
