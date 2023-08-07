package com.example.appbackend.converter;

import com.example.appbackend.dto.GetDepartementProjects;
import com.example.appbackend.dto.UserDepartementDto;
import com.example.appbackend.entities.Departement;
import com.example.appbackend.entities.Users;
import com.example.appbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartementConverter {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UserConverter userConverter;
    @Autowired
    ProjectConverter projectConverter;

    public UserDepartementDto entityUserDepartementToDto(Departement departement, Long id){
        UserDepartementDto userDepartementDto=new UserDepartementDto();
        userDepartementDto.setUsers(this.userConverter.entityToDto(usersRepository.findAllUsersByDepartementId(id)));
        userDepartementDto.setId(departement.getId());
        userDepartementDto.setFirstName(departement.getFirstName());
        return userDepartementDto;
    }

    public GetDepartementProjects entityDepartementProjects(Departement departement){
        GetDepartementProjects dto=new GetDepartementProjects();
        dto.setId(departement.getId());
        dto.setFirstName(departement.getFirstName());
        dto.setProjects(projectConverter.entityToDto(departement.getProjects()));
        return dto;
    }
}
