package com.example.appbackend.service;

import com.example.appbackend.dto.GetProjectDto;
import com.example.appbackend.dto.PostTaskDto;
import com.example.appbackend.dto.ProjectTasksDto;

public interface TaskService {
    public boolean addTasksByProjectsId(Long id, GetProjectDto getProjectDto);
    public boolean updateTask(Long id, PostTaskDto taskDto);
    public ProjectTasksDto getProjectTasks(Long id);
    }
