package com.surveyplatform.app.service.impl;

import com.surveyplatform.app.dto.UserDto;
import com.surveyplatform.app.persistance.entities.Usuario;
import com.surveyplatform.app.persistance.entities.manytomany.UsuarioRol;
import com.surveyplatform.app.persistance.repository.ModuleRepository;
import com.surveyplatform.app.persistance.repository.RoleRepository;
import com.surveyplatform.app.persistance.repository.SucursalRepository;
import com.surveyplatform.app.persistance.repository.UserRepository;
import com.surveyplatform.app.persistance.repository.UsuarioRolRepository;
import com.surveyplatform.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final SucursalRepository sucursalRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UsuarioRolRepository usuarioRolRepository;

    @Override
    public String getLoggedUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails userDetails) {
            return userDetails.getUsername();
        } else {
            return principal.toString();
        }
    }

    @Override
    @Transactional
    public void save(UserDto userDto) {
        var sucursal = sucursalRepository.findById(userDto.getSucursalId()).orElseThrow(() -> new RuntimeException("Sucursal not found"));
        var role = roleRepository.findById(userDto.getRolId()).orElseThrow(() -> new RuntimeException("Role not found"));
        // Save user
        var userToSave = Usuario.builder()
                .username(userDto.getUsername())
                .nombreCompleto(userDto.getNombreCompleto())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .sucursal(sucursal)
                .activo(userDto.isActivo())
                .build();
        var userSaved = userRepository.save(userToSave);
        var userRole = UsuarioRol.builder()
                .usuarioId(userSaved.getId())
                .rolId(role.getId())
                .build();
        usuarioRolRepository.save(userRole);
    }
}
