package com.surveyplatform.app.service.impl;

import com.surveyplatform.app.exception.SurveyPlatformException;
import com.surveyplatform.app.persistance.entities.Formulario;
import com.surveyplatform.app.persistance.repository.FormularioRepository;
import com.surveyplatform.app.persistance.repository.FormularioTipoRepository;
import com.surveyplatform.app.persistance.repository.ModuleRepository;
import com.surveyplatform.app.persistance.repository.UsuarioRepository;
import com.surveyplatform.app.service.FormularioService;
import com.surveyplatform.app.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormularioServiceImpl implements FormularioService {
    private final UsuarioRepository usuarioRepository;
    private final FormularioRepository formularioRepository;
    private final FormularioTipoRepository formularioTipoRepository;
    private final ModuleRepository moduleRepository;
    private final UsuarioService usuarioService;

    public Formulario saveFormByType(Long formTypeParam) {
        var usuarioLogueado = usuarioService.getLoggedUser();
        var usuario = usuarioRepository.findByEmail(usuarioLogueado).orElseThrow(() -> new SurveyPlatformException("Usuario no encontrado", 404));
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
