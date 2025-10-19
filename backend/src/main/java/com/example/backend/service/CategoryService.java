package com.example.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.model.Category;
import com.example.backend.dto.CategoryDTO;
import com.example.backend.model.User;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final UserService userService;

    // Constructor for CategoryService with dependency injection
    public CategoryService(CategoryRepository categoryRepository, UserService userService) {
        this.categoryRepository = categoryRepository;
        this.userService = userService;
    }

    // Retrieves all categories from the database
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    // Creates a new category in the database
    public Category create(CategoryDTO categoryDTO) {
        User user = userService.getById(categoryDTO.getUserId());

        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setType(categoryDTO.getType());
        category.setDescription(categoryDTO.getDescription());
        // Set the associated user
        category.setUser(user);
        
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