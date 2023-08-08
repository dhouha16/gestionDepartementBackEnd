package com.example.appbackend.service.impl;

import com.example.appbackend.dao.RoleDao;
import com.example.appbackend.dto.RoleDto;
import com.example.appbackend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;
    @Override
    public boolean addRole(RoleDto roleDto) {
        return roleDao.addRole(roleDto);
    }
}
