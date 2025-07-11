package com.techforge.service;

import com.techforge.models.Subcategory;
import com.techforge.repository.SubcategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;
    public SubcategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    @Transactional(readOnly = true)
    public List<Subcategory> findAll() {
        return subcategoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Subcategory> findById(int id) {
        return subcategoryRepository.findById(id);
    }

    @Transactional
    public Subcategory save(Subcategory subcategory) {
        return subcategoryRepository.save(subcategory);
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
