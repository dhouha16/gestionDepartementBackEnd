package com.example.appbackend.service.impl;

import com.example.appbackend.dao.UsersDao;
import com.example.appbackend.dto.UsersDto;
import com.example.appbackend.entities.Users;
import com.example.appbackend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersDao usersDao;

    @Override
    public boolean addUser(UsersDto usersDto) {
        return usersDao.addUser(usersDto);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersDao.getAllUsers();
    }

    @Override
    public Users getUserById(Long id) {
        return usersDao.getUserById(id);
    }

    @Override
    public boolean updateUser(Long id, UsersDto usersDto) {
        return usersDao.updateUser(id, usersDto);
    }

    @Override
    public boolean deleteUser(Long id) {
        return usersDao.deleteUser(id);
    }
}
