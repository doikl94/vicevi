package com.example.viceviGlavan.repository;

import com.example.viceviGlavan.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findByName(String name);
    List<Category> findAll();
}
