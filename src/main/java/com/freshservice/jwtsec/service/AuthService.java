package com.freshservice.jwtsec.service;

import com.freshservice.jwtsec.repository.UtilisateurRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {
    private final UtilisateurRepository utilisateurrepository;

    public AuthService(UtilisateurRepository utilisateurrepository) {
        this.utilisateurrepository = utilisateurrepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return utilisateurrepository.findUtilisateurByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
