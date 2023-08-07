package com.example.appbackend.service;

import com.example.appbackend.dto.UsersDto;
import com.example.appbackend.entities.Users;

import java.util.List;

public interface UsersService {
    boolean addUser(UsersDto usersDto);
    List<Users> getAllUsers();
    Users getUserById(Long id);
    boolean updateUser(Long id,UsersDto usersDto);
    boolean deleteUser(Long id);
}
