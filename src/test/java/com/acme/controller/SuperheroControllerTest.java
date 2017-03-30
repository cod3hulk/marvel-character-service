package com.acme.controller;

import com.acme.domain.Superhero;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SuperheroControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    public void get() throws Exception {
        // WHEN
        ResponseEntity<Superhero> entity = this.testRestTemplate.getForEntity("/superheroes/{id}", Superhero.class, 1L);

        // THEN
        assertThat(entity.getStatusCode(), is(HttpStatus.OK));

        Superhero superhero = entity.getBody();
        assertThat(superhero, notNullValue());
        assertThat(superhero.getId(), is(1L));
        assertThat(superhero.getName(), is("Spider-Man"));
        assertThat(superhero.getRealName(), is("Peter Benjamin Parker"));
        assertThat(superhero.getAbilities(), is("Has all abilities of a spider"));
    }

    @Test
    public void getAll() throws Exception {
        // WHEN
        ResponseEntity<Collection> entity = this.testRestTemplate.getForEntity("/superheroes", Collection.class);

        // THEN
        assertThat(entity.getStatusCode(), is(HttpStatus.OK));

        Collection<Superhero> superheros = entity.getBody();
        assertThat(superheros, hasSize(2));
    }

}