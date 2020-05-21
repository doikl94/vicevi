package com.example.viceviGlavan.service;

import com.example.viceviGlavan.models.Category;

import javax.jnlp.IntegrationService;
import java.util.List;

public interface CategoryService {
    Category findByName(String name);
    Category findById(Integer id);
    Category save(Category category);
    List<Category> findAll();
}
