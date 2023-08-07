package com.example.appbackend.repository;

import com.example.appbackend.entities.Departement;
import com.example.appbackend.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
