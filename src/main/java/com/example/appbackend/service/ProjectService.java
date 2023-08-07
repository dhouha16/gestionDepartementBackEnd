package com.example.appbackend.service;

import com.example.appbackend.dto.GetUserDto;
import com.example.appbackend.dto.ProjectDto;

import java.util.List;

public interface ProjectService {
    public boolean addProjectBydepartmentId(ProjectDto projectDto);
    public List<GetUserDto> getUsersByProjectsAnddepartmentId(Long id);
}
