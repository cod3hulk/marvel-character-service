package com.acme.controller;

import com.acme.domain.Superhero;
import com.acme.repository.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuperheroController {

    @Autowired
    private SuperheroRepository superheroRepository;


    @GetMapping("/superheroes/{id}")
    public Superhero getSuperhero(@PathVariable("id") Long id) {
        return superheroRepository.findOne(id);
    }

    @GetMapping("/superheroes")
    public Iterable<Superhero> getSuperheroes() {
        return superheroRepository.findAll();
    }

}
