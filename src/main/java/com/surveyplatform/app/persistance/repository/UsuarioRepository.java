package com.surveyplatform.app.persistance.repository;

import com.surveyplatform.app.persistance.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByUsername(String username);

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail, @Param("email") String email);

    @Query(value = "SELECT r.nombre " +
            "FROM seguridad.rol r " +
            "JOIN seguridad.usuario_rol ur ON r.id = ur.rol_id " +
            "JOIN seguridad.usuario u ON ur.usuario_id = u.id " +
            "WHERE u.username = :usernameOrEmail OR u.email = :email",
            nativeQuery = true)
    List<String> findRoleNamesByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail, @Param("email") String email);

    @Query(value = "SELECT r.id " +
            "FROM seguridad.rol r " +
            "JOIN seguridad.usuario_rol ur ON r.id = ur.rol_id " +
            "JOIN seguridad.usuario u ON ur.usuario_id = u.id " +
            "WHERE u.username = :usernameOrEmail OR u.email = :email",
            nativeQuery = true)
    List<Long> findRoleIdsByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail, @Param("email") String email);
}
