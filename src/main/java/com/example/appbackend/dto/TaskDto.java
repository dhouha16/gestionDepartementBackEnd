package com.example.appbackend.dto;

import com.example.appbackend.entities.Project;
import com.example.appbackend.entities.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class TaskDto {
    private Long id;
    private String description;
    private GetUserDto users;
}
