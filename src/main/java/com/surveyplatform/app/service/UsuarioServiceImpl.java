package com.surveyplatform.app.service;

import com.surveyplatform.app.persistance.entities.Usuario;
import com.surveyplatform.app.persistance.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        // Busca un usuario por su nombre de usuario
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        // Busca un usuario por su email
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public Optional<Usuario> findByUsernameOrEmail(String usernameOrEmail) {
        // Busca un usuario por su nombre de usuario o email
        return usuarioRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
    }

    @Override
    public Optional<Usuario> findByUsernameOrEmail(String username, String email) {
        // Busca un usuario por su nombre de usuario o email
        return usuarioRepository.findByUsernameOrEmail(username, email);
    }

    @Override
    public boolean existsByUsername(String username) {
        // Verifica si un usuario con el nombre de usuario especificado existe
        return usuarioRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        // Verifica si un usuario con el email especificado existe
        return usuarioRepository.existsByEmail(email);
    }
}
