package com.stackoverflow.exception;

/**
 * @author daniel.bubenheim@gmail.com
 */
public class DogNotFoundException extends Exception {

    public DogNotFoundException(final Long id) {
        super(String.format("Dog with id %d not found!", id));
    }
}
