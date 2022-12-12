package com.example.php_course2.repository;

import com.example.php_course2.model.Deputy;
import com.example.php_course2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeputyRepository extends JpaRepository<Deputy, Long> {
    Deputy findByName(String name);
    Deputy findByParty(String party);

    Deputy findDeputiesById(long id);
}
