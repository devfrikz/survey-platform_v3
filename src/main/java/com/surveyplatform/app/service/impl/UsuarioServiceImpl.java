package com.surveyplatform.app.service.impl;

import com.surveyplatform.app.persistance.entities.Usuario;
import com.surveyplatform.app.persistance.repository.UsuarioRepository;
import com.surveyplatform.app.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> findByUsernameOrEmail(String usernameOrEmail) {
        return usuarioRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
    }

    @Override
    public String getLoggedUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails userDetails) {
            return userDetails.getUsername();
        } else {
            return principal.toString();
        }
    }
}
