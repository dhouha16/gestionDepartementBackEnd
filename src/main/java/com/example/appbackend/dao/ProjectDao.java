package com.example.appbackend.dao;

import com.example.appbackend.dto.GetUserDto;
import com.example.appbackend.dto.ProjectDto;

import java.util.List;

public interface ProjectDao {
    boolean addProjectBydepartmentId(ProjectDto projectDto);
    public List<GetUserDto> getUsersByProjectsAnddepartmentId(Long id);
}
