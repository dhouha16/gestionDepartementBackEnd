package com.example.appbackend.converter;

import com.example.appbackend.dto.GetUserDto;
import com.example.appbackend.dto.TaskDto;
import com.example.appbackend.entities.Task;
import com.example.appbackend.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TaskConverter {
    @Autowired
    UserConverter userConverter;
    public TaskDto entityToDto(Task task){
        TaskDto dto=new TaskDto();
        dto.setId(task.getId());
        dto.setDescription(task.getDescription());
        dto.setUsers(userConverter.entityToDto(task.getUsers()));
        return dto;
    }

    public List<TaskDto> entityToDto(List<Task> tasks){
        return tasks.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }
}
