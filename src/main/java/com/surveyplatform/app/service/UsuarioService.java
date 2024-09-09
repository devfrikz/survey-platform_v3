package com.surveyplatform.app.service;

import com.surveyplatform.app.persistance.entities.Usuario;

import java.util.Optional;

public interface UsuarioService {


    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByUsernameOrEmail(String usernameOrEmail);

    Optional<Usuario> findByUsernameOrEmail(String username, String email);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    String getLoggedUser();
}
