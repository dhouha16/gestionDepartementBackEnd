package com.example.appbackend.repository;

import com.example.appbackend.entities.Project;
import com.example.appbackend.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
