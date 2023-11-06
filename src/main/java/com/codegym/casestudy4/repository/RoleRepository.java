package com.codegym.casestudy4.repository;

import com.codegym.casestudy4.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
    Roles findByName(String name);
}
