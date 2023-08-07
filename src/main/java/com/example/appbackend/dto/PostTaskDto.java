package com.example.appbackend.dto;

import com.example.appbackend.entities.Users;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostTaskDto {
    private Long id;
    private String description;
    private Users users;
}
