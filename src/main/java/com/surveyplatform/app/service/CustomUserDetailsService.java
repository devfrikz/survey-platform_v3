package com.surveyplatform.app.service;

import com.surveyplatform.app.persistance.entities.Usuario;
import com.surveyplatform.app.persistance.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);

        if (!usuarioOpt.isPresent()) {
            throw new UsernameNotFoundException("Usuario no encontrado con username o email: " + usernameOrEmail);
        }

        Usuario usuario = usuarioOpt.get();

        return User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles("ADMIN")  // Ajusta el rol según tu lógica
                .build();
    }
}
