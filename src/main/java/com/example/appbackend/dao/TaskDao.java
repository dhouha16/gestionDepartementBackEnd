package com.example.appbackend.dao;

import com.example.appbackend.dto.GetProjectDto;
import com.example.appbackend.dto.PostTaskDto;
import com.example.appbackend.dto.ProjectTasksDto;
import com.example.appbackend.dto.TaskDto;

public interface TaskDao {
    boolean addTasksByProjectsId(Long id, GetProjectDto getProjectDto);
    boolean updateTask(Long id, PostTaskDto taskDto);
    ProjectTasksDto getProjectTasks(Long id);
}
