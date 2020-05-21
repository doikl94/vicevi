package com.example.viceviGlavan.service;

import com.example.viceviGlavan.models.Joke;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface JokeService {
    Joke save(Joke joke);
    Joke like(Integer id);
    Joke dislike(Integer id);
    Page<Joke> findAll(PageRequest pageRequest);
}
