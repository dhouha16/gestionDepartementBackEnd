package com.example.appbackend.converter;

import com.example.appbackend.dto.GetDepartementProjects;
import com.example.appbackend.dto.GetProjectDto;
import com.example.appbackend.dto.GetUserDto;
import com.example.appbackend.dto.ProjectTasksDto;
import com.example.appbackend.entities.Project;
import com.example.appbackend.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectConverter {
    @Autowired
    TaskConverter taskConverter;
    public GetProjectDto entityToDto(Project project){
        GetProjectDto dto=new GetProjectDto();
        dto.setId(project.getId());
        dto.setDescription(project.getDescription());
        dto.setTasks(taskConverter.entityToDto(project.getTasks()));
        return dto;
    }

    public List<GetProjectDto> entityToDto(List<Project> projects){
        return projects.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public ProjectTasksDto projectTasksEntityToDto(Project project){
        ProjectTasksDto dto=new ProjectTasksDto();
        dto.setTasks(taskConverter.entityToDto(project.getTasks()));
        return dto;
    }



}
