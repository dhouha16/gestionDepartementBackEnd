package com.example.appbackend.dto;

import com.example.appbackend.entities.Departement;
import com.example.appbackend.entities.Task;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetProjectDto {
    private Long id;
    private String description;
    private Departement departement;
    private List<TaskDto> tasks ;
}
