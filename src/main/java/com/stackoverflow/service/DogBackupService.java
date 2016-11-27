package com.stackoverflow.service;

import com.stackoverflow.model.Dog;

import java.io.IOException;

/**
 * @author dbubenheim@communicode.de
 */
public interface DogBackupService {
    void backup(Dog dog) throws IOException;
}
