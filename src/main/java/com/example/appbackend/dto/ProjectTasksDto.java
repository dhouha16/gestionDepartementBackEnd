package com.example.appbackend.dto;

import com.example.appbackend.entities.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ProjectTasksDto {
    List<TaskDto> tasks;
}
