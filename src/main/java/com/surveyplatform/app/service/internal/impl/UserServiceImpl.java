package com.surveyplatform.app.service.internal.impl;

import com.surveyplatform.app.dto.internal.UserDto;
import com.surveyplatform.app.persistance.entities.internal.Usuario;
import com.surveyplatform.app.persistance.entities.internal.manytomany.UsuarioRol;
import com.surveyplatform.app.persistance.repository.internal.RoleRepository;
import com.surveyplatform.app.persistance.repository.internal.SucursalRepository;
import com.surveyplatform.app.persistance.repository.internal.UserRepository;
import com.surveyplatform.app.persistance.repository.internal.UsuarioRolRepository;
import com.surveyplatform.app.service.internal.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final SucursalRepository sucursalRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UsuarioRolRepository usuarioRolRepository;

    private final PasswordEncoder passwordEncoder;
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
        var userToSave = Usuario.builder()
                .username(userDto.getUsername())
                .nombreCompleto(userDto.getNombreCompleto())
                .email(userDto.getEmail())
                .password(passwordEncoder.encode(userDto.getPassword()))
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
