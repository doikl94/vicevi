package com.example.viceviGlavan.form;

import com.example.viceviGlavan.models.Joke;
import com.example.viceviGlavan.service.CategoryServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class JokeFormMapper {

    @Autowired
    private CategoryServiceImplementation categoryService;

    public Joke mapToEntity(JokeForm jokeForm) throws EntityNotFoundException {
        Joke joke = new Joke();
        joke.setContent(jokeForm.getContent());
        joke.setLikes(0);
        joke.setDislikes(0);
        joke.setDifference(0);
        joke.setCategory(categoryService.findById(jokeForm.getCategoryId()));
        return joke;
    }


}