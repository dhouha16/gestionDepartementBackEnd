package com.example.appbackend.dto;

import com.example.appbackend.entities.Departement;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class UserDepartementDto {
    private Long id;
    private String firstName;
    private List<GetUserDto> users;
}
