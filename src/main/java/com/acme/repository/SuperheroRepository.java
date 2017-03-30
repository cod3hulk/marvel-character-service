package com.acme.repository;

import com.acme.domain.Superhero;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SuperheroRepository extends CrudRepository<Superhero, Long> {

    Optional<Superhero> findById(Long id);
}
