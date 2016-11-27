package com.stackoverflow.controller;

import static java.util.Objects.requireNonNull;

import com.stackoverflow.exception.DogNotFoundException;
import com.stackoverflow.model.Dog;
import com.stackoverflow.service.DogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author daniel.bubenheim@gmail.com
 */
@RequestMapping("dogs")
@RestController
public class DogController {

    private final DogService dogService;

    public DogController(final DogService dogService) {
        this.dogService = requireNonNull(dogService, "dogService must not be null!");
    }

    @RequestMapping(value = "likeDog/{id}", method = RequestMethod.POST)
    public ResponseEntity like(@PathVariable("id") final Long id) throws DogNotFoundException, IOException {
        this.dogService.like(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllDogs() throws IOException {
        final Iterable<Dog> dogs = this.dogService.getAll();
        return ResponseEntity.ok().body(dogs);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity getDog(@PathVariable("id") final Long id) throws IOException, DogNotFoundException {
        final Dog dog = this.dogService.get(id);
        return ResponseEntity.ok().body(dog);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity postDog(@RequestBody final Dog dog) throws IOException {
        final Dog savedDog = this.dogService.save(dog);
        return ResponseEntity.ok().body(savedDog);
    }
}