package com.techforge.controller;

import com.techforge.models.Category;
import com.techforge.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.save(category);
        return ResponseEntity
                .created(URI.create("/api/categories/" + savedCategory.getId())) // http? URI COMPONENTS BUILDER
                .body(savedCategory);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) {
        return categoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category category) {
        return categoryService.findById(id).map(existing -> {
            existing.setName(category.getName());
            existing.setCode(category.getCode());
            existing.setShortDescription(category.getShortDescription());
            existing.setStudyGuide(category.getStudyGuide());
            existing.setStatus(category.getStatus());
            existing.setOrder(category.getOrder());
            existing.setIconPath(category.getIconPath());
            existing.setHtmlColorCode(category.getHtmlColorCode());
            Category updatedCategory = categoryService.save(existing);
            return ResponseEntity.ok(updatedCategory);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        boolean removed = categoryService.deleteById(id);
        return removed
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}