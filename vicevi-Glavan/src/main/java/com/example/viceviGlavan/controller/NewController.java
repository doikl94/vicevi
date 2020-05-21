package com.example.viceviGlavan.controller;

import com.example.viceviGlavan.form.JokeForm;
import com.example.viceviGlavan.form.JokeFormMapper;
import com.example.viceviGlavan.service.CategoryServiceImplementation;
import com.example.viceviGlavan.service.JokeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Controller
public class NewController implements WebMvcConfigurer {

    @Autowired
    CategoryServiceImplementation categoryService;
    @Autowired
    JokeServiceImplementation jokeService;
    @Autowired
    JokeFormMapper jokeFormMapper;


    @GetMapping("/new")
    public String newJoke(Model model) {
        JokeForm jokeForm = new JokeForm();
        model.addAttribute("jokeForm", jokeForm);
        model.addAttribute("categories", categoryService.findAll());
        return "new";
    }

    @PostMapping("/new")
    public ModelAndView saveJoke(@ModelAttribute("jokeForm") @Valid JokeForm jokeForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("new");
            return modelAndView;
        } else {
            try{
                jokeService.save(jokeFormMapper.mapToEntity(jokeForm));
                return new ModelAndView("redirect:/");
            }catch (EntityNotFoundException exception){
                ModelAndView modelAndView = new ModelAndView("new");
                modelAndView.addObject("errorMessage", "Joke category not found!");
                return modelAndView;
            }
        }

    }
}