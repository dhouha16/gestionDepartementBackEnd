package com.example.appbackend.service.impl;

import com.example.appbackend.dao.ProjectDao;
import com.example.appbackend.dto.GetUserDto;
import com.example.appbackend.dto.ProjectDto;
import com.example.appbackend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectDao projectDao;
    @Override
    public boolean addProjectBydepartmentId(ProjectDto projectDto) {
        return projectDao.addProjectBydepartmentId(projectDto);
    }

    @Override
    public List<GetUserDto> getUsersByProjectsAnddepartmentId(Long id) {
        return projectDao.getUsersByProjectsAnddepartmentId(id);
    }
}
