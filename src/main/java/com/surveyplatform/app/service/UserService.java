package com.surveyplatform.app.service;

import com.surveyplatform.app.dto.UserDto;

public interface UserService {
    String getLoggedUser();

    void save(UserDto userDto);
}
