package com.example.viceviGlavan.service;

import com.example.viceviGlavan.models.Category;
import com.example.viceviGlavan.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category findByName(String name) {
        if(name == null){
            return null;
        }
        return categoryRepository.findByName(name);
    }

    @Override
    public Category findById(Integer id) throws EntityNotFoundException {

        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
            return category.get();
        }else{
            throw new EntityNotFoundException();
        }
    }

    @Override
    public Category save(Category category) {
        if(category == null){
            return null;
        }
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
