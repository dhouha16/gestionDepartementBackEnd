package com.example.appbackend.service.impl;

import com.example.appbackend.dao.TaskDao;
import com.example.appbackend.dto.GetProjectDto;
import com.example.appbackend.dto.PostTaskDto;
import com.example.appbackend.dto.ProjectTasksDto;
import com.example.appbackend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskDao taskDao;
    @Override
    public boolean addTasksByProjectsId(Long id, GetProjectDto getProjectDto) {
        return taskDao.addTasksByProjectsId(id, getProjectDto);
    }

    @Override
    public boolean updateTask(Long id, PostTaskDto taskDto) {
        return taskDao.updateTask(id, taskDto);
    }

    @Override
    public ProjectTasksDto getProjectTasks(Long id) {
        return taskDao.getProjectTasks(id);
    }
}
