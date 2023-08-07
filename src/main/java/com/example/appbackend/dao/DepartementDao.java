package com.example.appbackend.dao;

import com.example.appbackend.dto.DepartementDto;
import com.example.appbackend.dto.GetDepartementProjects;
import com.example.appbackend.dto.UserDepartementDto;
import com.example.appbackend.entities.Departement;

import java.util.List;
import java.util.Optional;

public interface DepartementDao {
 boolean addDepatement(DepartementDto departementDto);
 List<Departement> getAllDepartement();
 Departement getDepartementById(Long id);
 boolean updateDepatement(Long id,DepartementDto departementDto);
 boolean deleteDepartement(Long id);
 UserDepartementDto getUsersByDepartementId(Long id);
 boolean updateUsersByDepartementId(DepartementDto departementDto,Long id);
 GetDepartementProjects getProjectBydepartmentId(Long id);

}
