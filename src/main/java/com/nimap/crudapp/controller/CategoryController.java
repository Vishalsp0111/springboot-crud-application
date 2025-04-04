package com.nimap.crudapp.controller;

import com.nimap.crudapp.entity.Category;
import com.nimap.crudapp.services.implementations.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

    @RestController
    @RequestMapping("/api/categories")

    public class CategoryController {
        @Autowired
        private CategoryService categoryService;

        @GetMapping
        public Page<Category> getAllCategories(Pageable pageable) {
            return categoryService.getAllCategories(pageable);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
            Optional<Category> category = categoryService.getCategoryById(id);
            return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public Category createCategory(@RequestBody Category category) {
            return categoryService.createCategory(category);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
            return ResponseEntity.ok(categoryService.updateCategory(id, category));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
            categoryService.deleteCategory(id);
            return ResponseEntity.noContent().build();
        }


    }

