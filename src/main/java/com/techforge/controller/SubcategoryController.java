package com.techforge.controller;

import com.techforge.dto.SubcategoryDTO;
import com.techforge.models.Subcategory;
import com.techforge.service.SubcategoryService;
import jakarta.validation.Valid;
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

    @PostMapping
    public ResponseEntity<SubcategoryDTO> create(
            @Valid @RequestBody SubcategoryDTO dto
    ) {
        SubcategoryDTO saved = subcategoryService.save(dto);
        return ResponseEntity
                .created(URI.create("/api/subcategories/" + saved.id()))
                .body(saved);
    }


    @GetMapping
    public List<SubcategoryDTO> getAll() {
        return subcategoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SubcategoryDTO> getById(@PathVariable int id) {
        return subcategoryService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SubcategoryDTO> update(
            @PathVariable int id,
            @Valid @RequestBody SubcategoryDTO dto
    ) {
        SubcategoryDTO updated = subcategoryService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        boolean deleted = subcategoryService.deleteById(id);
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

}
