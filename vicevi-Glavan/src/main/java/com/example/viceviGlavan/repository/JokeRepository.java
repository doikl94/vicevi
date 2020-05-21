package com.example.viceviGlavan.repository;

import com.example.viceviGlavan.models.Joke;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JokeRepository extends JpaRepository<Joke, Integer> {
}
