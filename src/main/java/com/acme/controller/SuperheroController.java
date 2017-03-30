package com.acme.controller;

import com.acme.domain.Superhero;
import com.acme.exception.ResourceNotFoundException;
import com.acme.repository.SuperheroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/superheroes")
public class SuperheroController {

    @Autowired
    private SuperheroRepository superheroRepository;


    @GetMapping("/{id}")
    public Superhero get(@PathVariable("id") Long id) {
        return superheroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @GetMapping
    public Iterable<Superhero> getAll() {
        return superheroRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Superhero save(@RequestBody Superhero superhero) {
        return superheroRepository.save(superhero);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        superheroRepository.delete(id);
    }


}
