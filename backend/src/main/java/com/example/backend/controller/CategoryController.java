package com.example.backend.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.backend.service.CategoryService;
import com.example.backend.model.Category;
import org.springframework.web.bind.annotation.*;
import com.example.backend.dto.CategoryDTO;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Endpoint to retrieve all categories
    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAll();
    }

    // Endpoint to create a new category
    @PostMapping
    public Category createCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        return categoryService.create(categoryDTO);
    }

    // Endpoint to retrieve a category by ID
    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getById(id);
    }

    // Endpoint to delete a category by ID
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
