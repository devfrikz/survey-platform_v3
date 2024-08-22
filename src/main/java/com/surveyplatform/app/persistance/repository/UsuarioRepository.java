package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByUsernameOrEmail(String username, String email);
    List<Usuario> findByIdIn(List<Integer> userIds);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
