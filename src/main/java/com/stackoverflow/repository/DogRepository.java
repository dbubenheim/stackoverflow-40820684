package com.stackoverflow.repository;

import com.stackoverflow.model.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author daniel.bubenheim@gmail.com
 */
@Repository
public interface DogRepository extends CrudRepository<Dog, Long> {
    // empty
}
