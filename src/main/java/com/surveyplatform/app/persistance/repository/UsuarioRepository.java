package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsername(String username);

    Optional<Usuario> findByEmail(String email);


    List<Usuario> findByIdIn(List<Integer> userIds);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}

