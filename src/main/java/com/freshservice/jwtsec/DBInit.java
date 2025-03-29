package com.freshservice.jwtsec;


import com.freshservice.jwtsec.entity.Utilisateur;
import com.freshservice.jwtsec.repository.UtilisateurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final UtilisateurRepository utilisateurRepo;
    private final PasswordEncoder passwordEncoder;


    public DBInit(UtilisateurRepository utilisateurRepo, PasswordEncoder passwordEncoder) {
        this.utilisateurRepo = utilisateurRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (utilisateurRepo.findUtilisateurByUsername("admin").isEmpty()) {
            Utilisateur admin = new Utilisateur();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("admin")); // encode the password
            admin.setEmail("admin@example.com"); // ✅ required
            admin.setRole("ADMIN");
            utilisateurRepo.save(admin);

            Utilisateur a2 = new Utilisateur();
            a2.setUsername("user");
            a2.setPassword(passwordEncoder.encode("user")); // encode the password
            a2.setEmail("user@example.com"); // ✅ required
            a2.setRole("USER");
            utilisateurRepo.save(a2);
            System.out.println("✅ user  created.");
        }
    }
}

