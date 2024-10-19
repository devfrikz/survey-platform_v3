package com.surveyplatform.app.service.internal;

import com.surveyplatform.app.dto.internal.UserDto;

public interface UserService {
    String getLoggedUser();

    void save(UserDto userDto);
}
