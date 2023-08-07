package com.example.appbackend.dao.impl;

import com.example.appbackend.converter.UserConverter;
import com.example.appbackend.dao.UsersDao;
import com.example.appbackend.dto.UserDepartementDto;
import com.example.appbackend.dto.UsersDto;
import com.example.appbackend.entities.Departement;
import com.example.appbackend.entities.Users;
import com.example.appbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UserConverter userConverter;
    @Override
    public boolean addUser(UsersDto usersDto) {
        Users user=new Users();
        user.setFirstName(usersDto.getFirstName());
        user.setLastName(usersDto.getLastName());
        user.setEmail(usersDto.getEmail());
        user.setDepartement(usersDto.getDepartement());
        user.setStatus(usersDto.isStatus());
        usersRepository.save(user);
        return true;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        if(usersRepository.findById(id).isPresent())
        return usersRepository.findById(id).get();
        else return null;
    }

    @Override
    public boolean updateUser(Long id, UsersDto usersDto) {
        if(usersRepository.findById(id).isPresent()) {
            Users user=usersRepository.findById(id).get();
            user.setFirstName(usersDto.getFirstName());
            user.setLastName(usersDto.getLastName());
            user.setEmail(usersDto.getEmail());
            user.setDepartement(usersDto.getDepartement());
            user.setStatus(usersDto.isStatus());
            usersRepository.save(user);
            return true;
        }else
            return false;
    }

    @Override
    public boolean deleteUser(Long id) {
        if(usersRepository.findById(id).isPresent()) {
            usersRepository.deleteById(id);
            return true;
        }else
            return false;
    }


}
