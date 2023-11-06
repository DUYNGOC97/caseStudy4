package com.codegym.casestudy4.repository;

import com.codegym.casestudy4.entity.Roles;
import com.codegym.casestudy4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    User findByUsername(String username);
    User findById(long id);

}
