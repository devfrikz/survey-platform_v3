package com.surveyplatform.app.service;

import com.surveyplatform.app.persistance.entities.Formulario;

public interface FormularioService {
    Formulario saveFormByType(Long formTypeParam);
}
