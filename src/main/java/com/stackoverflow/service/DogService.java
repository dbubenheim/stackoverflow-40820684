package com.stackoverflow.service;

import com.stackoverflow.model.Dog;
import com.stackoverflow.exception.DogNotFoundException;

import java.io.IOException;

/**
 * @author daniel.bubenheim@gmail.com
 */
public interface DogService {
    Dog save(Dog dog) throws IOException;

    Dog get(Long id) throws DogNotFoundException;

    Iterable<Dog> getAll();

    Dog like(Long id) throws IOException, DogNotFoundException;
}