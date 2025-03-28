package com.freshservice.seguridad4;

import com.freshservice.seguridad4.entity.Utilisateur;
import com.freshservice.seguridad4.repostitory.UtilisateurRepo;
import com.freshservice.seguridad4.service.UtilisateurService;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Seguridad4Application {


    public static void main(String[] args) {
        SpringApplication.run(Seguridad4Application.class,
                args);

    }


//    @Bean
//    CommandLineRunner initDB(UtilisateurRepo utilisateurRepo) {
//        return (args) -> {
//            utilisateurRepo.save(
//                    Utilisateur.builder()
//                            .id(1)
//                            .username("admin")
//                            .email("admin@freshservice.com")
//                            .password("$2a$10$7XC.XxjlMZ6ZpZUjvqHjnOqjKUjZpQ5e3ZJ4fF6hR8pN3mL2kK1iG")
//                            .build());
//        };
//    }
}

