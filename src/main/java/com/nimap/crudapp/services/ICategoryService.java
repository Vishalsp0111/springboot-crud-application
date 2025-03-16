package com.nimap.crudapp.services;

import com.nimap.crudapp.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICategoryService {
    Page<Category> getAllCategories(Pageable pageable);
    Optional<Category> getCategoryById(Long id);
    Category createCategory(Category category);
    Category updateCategory(Long id, Category categoryDetails);
    void deleteCategory(Long id);
}
