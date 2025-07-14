package com.techforge.controller;

import com.techforge.models.Subcategory;
import com.techforge.service.SubcategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/subcategories")
public class SubcategoryController {
    private final SubcategoryService subcategoryService;

    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @PostMapping// CHECK PATH??
    public ResponseEntity<Subcategory> create(@RequestBody Subcategory subcategory) {
        Subcategory savedSubcategory = subcategoryService.save(subcategory);
        return ResponseEntity
                .created(URI.create("/subcategory/" + savedSubcategory.getId()))
                .body(savedSubcategory);
    }


    @GetMapping
    public List<Subcategory> getAll() {
        return subcategoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subcategory> getSubcategoryById(@PathVariable int id) {
        return subcategoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subcategory> updateSubcategory(
            @PathVariable int id,
            @RequestBody Subcategory subcategory
    ) {
        return subcategoryService.findById(id).map(existing -> {
            existing.setName(subcategory.getName());
            existing.setCode(subcategory.getCode());
            existing.setShortDescription(subcategory.getShortDescription());
            existing.setStudyGuide(subcategory.getStudyGuide());
            existing.setStatus(subcategory.getStatus());
            existing.setOrder(subcategory.getOrder());
            existing.setCategory(subcategory.getCategory());
            Subcategory updated = subcategoryService.save(existing);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubcategory(@PathVariable int id) {
        boolean removed = subcategoryService.deleteById(id);
        return removed
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

}
