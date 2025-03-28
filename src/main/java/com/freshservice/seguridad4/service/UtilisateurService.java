package com.freshservice.seguridad4.service;


import com.freshservice.seguridad4.entity.Utilisateur;
import com.freshservice.seguridad4.repostitory.UtilisateurRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService implements UserDetailsService {

    private final UtilisateurRepo utilisateurRepository;

    public UtilisateurService(UtilisateurRepo utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return utilisateurRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public List<Utilisateur> getAllUtilisateurs() {
       return utilisateurRepository.findAll();
    }
}
