package com.stackoverflow.service.impl;

import static java.util.Objects.requireNonNull;

import com.stackoverflow.exception.DogNotFoundException;
import com.stackoverflow.model.Dog;
import com.stackoverflow.repository.DogRepository;
import com.stackoverflow.service.DogBackupService;
import com.stackoverflow.service.DogService;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author daniel.bubenheim@gmail.com
 */
@Service
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;
    private final DogBackupService dogBackupService;

    public DogServiceImpl(final DogRepository dogRepository, final DogBackupService dogBackupService) {
        this.dogRepository = requireNonNull(dogRepository, "dogRepository must not be null!");
        this.dogBackupService = requireNonNull(dogBackupService, "dogBackupService must not be null!");
    }

    @Override
    public Dog save(final Dog dog) throws IOException {
        final Dog savedDog = this.dogRepository.save(dog);
        this.dogBackupService.backup(savedDog);
        return savedDog;
    }

    @Override
    public Dog get(final Long id) throws DogNotFoundException {
        final Dog dog = this.dogRepository.findOne(id);
        if (dog == null) {
            throw new DogNotFoundException(id);
        }
        return dog;
    }

    @Override
    public Iterable<Dog> getAll() {
        return this.dogRepository.findAll();
    }

    @Override
    public Dog like(final Long id) throws IOException, DogNotFoundException {
        final Dog dog = this.get(id);
        dog.like();
        final Dog savedDog = this.dogRepository.save(dog);
        this.dogBackupService.backup(savedDog);
        return savedDog;
    }
}