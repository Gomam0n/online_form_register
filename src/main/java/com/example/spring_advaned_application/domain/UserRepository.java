package com.example.spring_advaned_application.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByUsernameAndPassword(String username, String password);

}
