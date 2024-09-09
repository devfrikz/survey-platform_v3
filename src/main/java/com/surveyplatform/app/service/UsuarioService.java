package com.surveyplatform.app.service;

import com.surveyplatform.app.persistance.entities.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Optional<Usuario> findByUsernameOrEmail(String usernameOrEmail);
    String getLoggedUser();
}
