package com.stackoverflow.service;

import com.stackoverflow.model.Dog;

import java.io.IOException;

/**
 * @author daniel.bubenheim@gmail.com
 */
public interface DogBackupService {
    void backup(Dog dog) throws IOException;
}
