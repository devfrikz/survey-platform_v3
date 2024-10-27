package com.surveyplatform.app.service.forms;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Primary
@Service
public interface CustomUserDetailsService extends UserDetailsService {
}
