package com.sergioarboleda.cacharrero.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.sergioarboleda.cacharrero.app.repository.crud.CloneCrudRepository;
import com.sergioarboleda.cacharrero.app.repository.crud.UserCrudRepository;


/**
 *
 * @author Carotobarj
 */
@SpringBootApplication
public class Reto3cacharreroApplication implements CommandLineRunner {

    @Autowired
    private CloneCrudRepository cloneRepository;

    @Autowired
    private UserCrudRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Reto3cacharreroApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        cloneRepository.deleteAll();

    }

}