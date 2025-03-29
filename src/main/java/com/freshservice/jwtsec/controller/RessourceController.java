package com.freshservice.jwtsec.controller;

import com.freshservice.jwtsec.entity.Utilisateur;
import com.freshservice.jwtsec.repository.UtilisateurRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class RessourceController {
    private final UtilisateurRepository repo;

    public RessourceController(UtilisateurRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public ResponseEntity<List<Utilisateur>> getRessource() {
        List<Utilisateur> u = repo.findAll();
        return ResponseEntity.ok().body(u);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> adminDashboard(Authentication authentication) {
        System.out.println(authentication.getAuthorities());


        return ResponseEntity.ok("you are an admin");
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user")
    public ResponseEntity<String> userDashboard(Authentication authentication) {
        System.out.println(authentication.getAuthorities());


        return ResponseEntity.ok("you are a simple user");
    }

}
