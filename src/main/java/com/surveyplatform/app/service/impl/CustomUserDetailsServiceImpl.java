package com.surveyplatform.app.service.impl;

import com.surveyplatform.app.persistance.entities.Usuario;
import com.surveyplatform.app.persistance.repository.UsuarioRepository;
import com.surveyplatform.app.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    private final UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);

        if (usuarioOpt.isEmpty()) {
            throw new UsernameNotFoundException("Usuario no encontrado con username o email: " + usernameOrEmail);
        }

        Usuario usuario = usuarioOpt.get();

        var roles = usuarioRepository.findRoleNamesByUsernameOrEmail(usernameOrEmail, usernameOrEmail);

        var userSearched = User.builder()
                .username(usuario.getUsername())
                .password(usuario.getPassword())
                .roles(roles.toArray(String[]::new))
                .build();

        return userSearched;
    }
}
