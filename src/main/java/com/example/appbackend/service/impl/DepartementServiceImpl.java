package com.example.appbackend.service.impl;

import com.example.appbackend.dao.DepartementDao;
import com.example.appbackend.dto.DepartementDto;
import com.example.appbackend.dto.GetDepartementProjects;
import com.example.appbackend.dto.UserDepartementDto;
import com.example.appbackend.entities.Departement;
import com.example.appbackend.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartementServiceImpl implements DepartementService {
    @Autowired
    DepartementDao departementDao;

    @Override
    public boolean addDepatement(DepartementDto departementDto) {
        return departementDao.addDepatement(departementDto);
    }

    @Override
    public List<Departement> getAllDepartement() {
        return departementDao.getAllDepartement();
    }

    @Override
    public Departement getDepartementById(Long id) {
        return departementDao.getDepartementById(id);
    }

    @Override
    public boolean updateDepatement(Long id, DepartementDto departementDto) {
        return departementDao.updateDepatement(id, departementDto);
    }

    @Override
    public boolean deleteDepartement(Long id) {
        return departementDao.deleteDepartement(id);
    }

    @Override
    public UserDepartementDto getUsersByDepartementId(Long id) {
        return departementDao.getUsersByDepartementId(id);
    }
    @Override
    public boolean updateUsersByDepartementId(DepartementDto departementDto,Long id){
        return departementDao.updateUsersByDepartementId(departementDto, id);
    }

    @Override
    public GetDepartementProjects getProjectBydepartmentId(Long id) {
        return departementDao.getProjectBydepartmentId(id);
    }
}
