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
        var user = usuarioRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->new UsernameNotFoundException("Usuario no encontrado con username o email: " + usernameOrEmail));

        var userRoleList = user.getUsuarioRoles().stream().map(item -> item.getRol().getNombre()).toList();

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(userRoleList.toArray(String[]::new))
                .build();
    }
}
