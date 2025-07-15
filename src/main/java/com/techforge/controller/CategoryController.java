package com.techforge.controller;

import com.techforge.dto.CategoryDTO;
import com.techforge.models.Category;
import com.techforge.service.CategoryService;
import jakarta.validation.Valid;
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
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody @Valid CategoryDTO dto) {
        CategoryDTO savedCategory = categoryService.save(dto);
        return ResponseEntity
                .created(URI.create("/api/categories/" + savedCategory.id())) // http? URI COMPONENTS BUILDER
                .body(savedCategory);
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable int id) {
        return categoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable int id, @RequestBody @Valid CategoryDTO dto) {
        return ResponseEntity.ok(categoryService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        boolean removed = categoryService.deleteById(id);
        return removed
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}