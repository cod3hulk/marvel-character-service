package com.acme.controller;

import com.acme.domain.Superhero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/superhero")
public class SuperheroController {

    @GetMapping
    public Superhero get() {

        Superhero superhero = new Superhero();
        superhero.setName("Wolverine");
        superhero.setAge(-1);
        superhero.setSuperpower("Adamantium-plated skeletal");

        return superhero;
    }
}
