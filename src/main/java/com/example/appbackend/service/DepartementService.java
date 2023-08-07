package com.example.appbackend.service;

import com.example.appbackend.dto.DepartementDto;
import com.example.appbackend.dto.GetDepartementProjects;
import com.example.appbackend.dto.UserDepartementDto;
import com.example.appbackend.entities.Departement;

import java.util.List;

public interface DepartementService {
    boolean addDepatement(DepartementDto departementDto);
    List<Departement> getAllDepartement();
    Departement getDepartementById(Long id);
    boolean updateDepatement(Long id,DepartementDto departementDto);
    boolean deleteDepartement(Long id);
    UserDepartementDto getUsersByDepartementId(Long id);
    boolean updateUsersByDepartementId(DepartementDto departementDto,Long id);
    public GetDepartementProjects getProjectBydepartmentId(Long id);
}
