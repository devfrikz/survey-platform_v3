package com.surveyplatform.app.service.forms.impl;

import com.surveyplatform.app.exception.SurveyPlatformException;
import com.surveyplatform.app.persistance.entities.forms.Formulario;
import com.surveyplatform.app.persistance.repository.forms.FormularioRepository;
import com.surveyplatform.app.persistance.repository.forms.FormularioTipoRepository;
import com.surveyplatform.app.persistance.repository.internal.ModuleRepository;
import com.surveyplatform.app.persistance.repository.internal.UserRepository;
import com.surveyplatform.app.service.forms.FormularioService;
import com.surveyplatform.app.service.internal.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormularioServiceImpl implements FormularioService {
    private final UserRepository userRepository;
    private final FormularioRepository formularioRepository;
    private final FormularioTipoRepository formularioTipoRepository;
    private final ModuleRepository moduleRepository;
    private final UserService userService;

    public Formulario saveFormByType(Long formTypeParam) {
        var usuarioLogueado = userService.getLoggedUser();
        var usuario = userRepository.findByEmail(usuarioLogueado).orElseThrow(() -> new SurveyPlatformException("Usuario no encontrado", 404));
        var formType = formularioTipoRepository.findById(formTypeParam).orElseThrow(() -> new SurveyPlatformException("Tipo de formulario no encontrado", 404));
        var module = moduleRepository.findById(1L).orElseThrow(() -> new SurveyPlatformException("Modulo no encontrado", 404));//TODO ver de donde obtener el modulo

        var form = Formulario.builder()
                .nombre(formType.getTipo())
                .descripcion(formType.getDescripcion())
                .modulo(module)
                .tipo(formType)
                .usuario(usuario)
                .sucursal(usuario.getSucursal())
                .build();

        return formularioRepository.save(form);
    }

}
