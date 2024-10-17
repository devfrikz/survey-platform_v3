package com.surveyplatform.app.service.impl;

import com.surveyplatform.app.persistance.entities.Role;
import com.surveyplatform.app.persistance.entities.manytomany.UsuarioRol;
import com.surveyplatform.app.persistance.repository.RoleRepository;
import com.surveyplatform.app.persistance.repository.UserRepository;
import com.surveyplatform.app.persistance.repository.UsuarioRolRepository;
import com.surveyplatform.app.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UsuarioRolRepository usuarioRolRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        var user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() ->new UsernameNotFoundException("Usuario no encontrado con username o email: " + usernameOrEmail));
        var userRoleList = usuarioRolRepository.findAllByUsuarioId(user.getId());

        var userRoleIdList = userRoleList.stream().map(UsuarioRol::getRolId).toList();
        var userRoleNameList = roleRepository.findAllById(userRoleIdList).stream().map(Role::getNombre).toList();

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(userRoleNameList.toArray(String[]::new))
                .build();
    }
}
