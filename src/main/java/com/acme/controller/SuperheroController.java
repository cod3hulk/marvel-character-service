package com.acme.controller;

import com.acme.domain.Superhero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuperheroController {

    @GetMapping("/superheroes/{id}")
    public Superhero get(@PathVariable("id") Long id) {

        Superhero superhero = new Superhero();
        superhero.setId(id);
        superhero.setName("Wolverine");
        superhero.setAge(-1);
        superhero.setSuperpower("Adamantium-plated skeletal");

        return superhero;
    }
}
