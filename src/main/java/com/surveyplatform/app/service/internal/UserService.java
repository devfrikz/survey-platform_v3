package com.surveyplatform.app.service.internal;

import com.surveyplatform.app.dto.internal.UserDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    UserDetails getLoggedUser();

    void save(UserDto userDto);
}
