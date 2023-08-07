package com.example.appbackend.repository;

import com.example.appbackend.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository  extends JpaRepository<Departement, Long> {
}
