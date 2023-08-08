package com.example.appbackend.dao.impl;

import com.example.appbackend.dao.RoleDao;
import com.example.appbackend.dto.RoleDto;
import com.example.appbackend.entities.Role;
import com.example.appbackend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    RoleRepository roleRepository;
    @Override
    public boolean addRole(RoleDto roleDto) {
        Role role=new Role();
        role.setNomRole(roleDto.getNomRole());
        roleRepository.save(role);
        return true;
    }
}
