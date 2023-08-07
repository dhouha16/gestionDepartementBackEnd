package com.example.appbackend.dao;

import com.example.appbackend.dto.DepartementDto;
import com.example.appbackend.dto.UserDepartementDto;
import com.example.appbackend.dto.UsersDto;
import com.example.appbackend.entities.Departement;
import com.example.appbackend.entities.Users;

import java.util.List;

public interface UsersDao {
    boolean addUser(UsersDto usersDto);
    List<Users> getAllUsers();
    Users getUserById(Long id);
    boolean updateUser(Long id,UsersDto usersDto);
    boolean deleteUser(Long id);


}
