package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.manytomany.UsuarioRol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Integer> {
    List<UsuarioRol> findAllByUsuarioId(Long id);
}
