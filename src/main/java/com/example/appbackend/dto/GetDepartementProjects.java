package com.example.appbackend.dto;

import com.example.appbackend.entities.Users;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class GetDepartementProjects {
    private Long id;
    private String firstName;
    private List<GetProjectDto> projects ;
}
