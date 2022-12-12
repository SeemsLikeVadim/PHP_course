package com.example.php_course2.service;

import com.example.php_course2.model.Deputy;
import com.example.php_course2.model.User;
import com.example.php_course2.web.dto.DeputyDto;

import java.util.List;


public interface DeputyService {
    Deputy save(DeputyDto deputyDto);

    List<Deputy> getAll();

    void deleteAll();

    void deleteDeputyById(long id);

    Deputy findById(long id);

    Deputy updateDeputy(DeputyDto deputyDto);

    void plusVote(long id, String email);

    List<User> whoVote(long id);
}
