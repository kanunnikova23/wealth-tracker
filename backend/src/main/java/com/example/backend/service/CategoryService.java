package com.example.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.model.Category;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    // Constructor for CategoryService with dependency injection
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Retrieves all categories from the database
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    // Creates a new category in the database
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    // Retrieves a category by ID from the database
    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    // Deletes a category by ID from the database
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
    // update category
    public Category update(Long id, Category updatedCategory) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(updatedCategory.getName());
        category.setType(updatedCategory.getType());

        return categoryRepository.save(category);
    }
}