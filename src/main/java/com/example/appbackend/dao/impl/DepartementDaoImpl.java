package com.example.appbackend.dao.impl;

import com.example.appbackend.converter.DepartementConverter;
import com.example.appbackend.dao.DepartementDao;
import com.example.appbackend.dto.DepartementDto;
import com.example.appbackend.dto.GetDepartementProjects;
import com.example.appbackend.dto.UserDepartementDto;
import com.example.appbackend.entities.Departement;
import com.example.appbackend.entities.Users;
import com.example.appbackend.repository.DepartementRepository;
import com.example.appbackend.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DepartementDaoImpl implements DepartementDao {
    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    DepartementConverter departementConverter;
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean addDepatement(DepartementDto departementDto) {
        Departement departement=new Departement();
        departement.setFirstName(departementDto.getFirstName());
        departementRepository.save(departement);
        return true;
    }

    @Override
    public List<Departement> getAllDepartement() {
        return departementRepository.findAll();
    }

    @Override
    public Departement getDepartementById(Long id) {
        if(departementRepository.findById(id).isPresent())
        return departementRepository.findById(id).get();
        else
        return null;
    }

    @Override
    public boolean updateDepatement(Long id, DepartementDto departementDto) {
        if(departementRepository.findById(id).isPresent()) {
            Departement departement = departementRepository.findById(id).get();
            departement.setFirstName(departementDto.getFirstName());
            departementRepository.save(departement);
            return true;
        } else
            return false;
    }

    @Override
    public boolean deleteDepartement(Long id) {
        if(departementRepository.findById(id).isPresent()) {
            departementRepository.deleteById(id);
            return true;
        } else
            return false;
    }

    @Override
    public UserDepartementDto getUsersByDepartementId(Long id) {
        if(departementRepository.findById(id).isPresent())
            return  departementConverter.entityUserDepartementToDto(departementRepository.findById(id).get(),id);
        else
            return null;

    }

    @Override
    public boolean updateUsersByDepartementId(DepartementDto departementDto, Long id) {
        boolean status= false;
        if(departementRepository.findById(id).isPresent()) {
            Departement departement = departementRepository.findById(id).get();
            if(departementDto.getUsers().size()!=0){
                for(int i=0;i<departementDto.getUsers().size();i++){
                    Users user=usersRepository.findById(departementDto.getUsers().get(i).getId()).get();
                    user.setStatus(departementDto.getUsers().get(i).isStatus());
                    System.out.println("-------- "+departementDto.getUsers().get(i).isStatus());
                    usersRepository.save(user);
                    System.out.println("-------- "+departementDto.getUsers().get(i).isStatus());
                    status=true;
                }
            }
        }
        return status;
    }

    @Override
    public GetDepartementProjects getProjectBydepartmentId(Long id) {
       if(departementRepository.findById(id).isPresent()){
           return departementConverter.entityDepartementProjects(departementRepository.findById(id).get());
        }else
        return null;
    }
}
