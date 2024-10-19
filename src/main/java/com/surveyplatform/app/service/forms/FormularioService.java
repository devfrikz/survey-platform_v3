package com.surveyplatform.app.service.forms;

import com.surveyplatform.app.persistance.entities.forms.Formulario;

public interface FormularioService {
    Formulario saveFormByType(Long formTypeParam);
}
