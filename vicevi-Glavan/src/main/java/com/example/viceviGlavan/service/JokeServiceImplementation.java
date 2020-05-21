package com.example.viceviGlavan.service;

import com.example.viceviGlavan.models.Joke;
import com.example.viceviGlavan.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class JokeServiceImplementation implements JokeService {

    @Autowired
    private JokeRepository jokeRepository;

    @Override
    public Joke save(Joke joke) {
        if(joke == null){
            return null;
        }
        return jokeRepository.save(joke);
    }

    @Override
    public Joke like(Integer id) {
        if(id == null){
            return null;
        }
        Optional<Joke> joke = jokeRepository.findById(id);
        joke.get().setLikes(joke.get().getLikes()+1);
        joke.get().setDifference(joke.get().getLikes()-joke.get().getDislikes());
        return jokeRepository.save(joke.get());
    }

    @Override
    public Joke dislike(Integer id) {
        if(id == null){
            return null;
        }
        Optional<Joke> joke = jokeRepository.findById(id);
        joke.get().setDislikes(joke.get().getDislikes()+1);
        joke.get().setDifference(joke.get().getLikes()-joke.get().getDislikes());
        return jokeRepository.save(joke.get());
    }

    @Override
    public Page<Joke> findAll(PageRequest pageRequest) {
        if(pageRequest == null){
            return null;
        }
        return jokeRepository.findAll(pageRequest);
    }
}
