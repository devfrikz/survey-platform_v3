package com.surveyplatform.app.service;

import com.surveyplatform.app.persistance.entities.Usuario;
import com.surveyplatform.app.persistance.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el nombre: " + username));

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles("USER") // Configura roles según lo necesites
                .build();
    }
}
