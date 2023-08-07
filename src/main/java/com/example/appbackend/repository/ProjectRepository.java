package com.example.appbackend.repository;

import com.example.appbackend.entities.Departement;
import com.example.appbackend.entities.Project;
import com.example.appbackend.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query(value = "select * from project where departement_id=:id",nativeQuery = true)
    List<Project> findAllProjectByDepartementId(@Param("id")Long id);
}
