package com.example.php_course2.service;

import com.example.php_course2.model.Deputy;
import com.example.php_course2.model.User;
import com.example.php_course2.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

    User findByEmail(String email);
}