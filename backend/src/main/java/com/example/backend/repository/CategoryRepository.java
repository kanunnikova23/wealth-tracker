package com.example.backend.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
    Category findByName(String name);
    Category findByType(String type);
}
