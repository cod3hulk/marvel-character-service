package com.acme.repository;

import com.acme.domain.Superhero;
import org.springframework.data.repository.CrudRepository;

public interface SuperheroRepository extends CrudRepository<Superhero, Long> {
}
