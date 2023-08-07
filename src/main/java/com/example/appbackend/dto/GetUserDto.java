package com.example.appbackend.dto;

import com.example.appbackend.entities.Departement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean status;
}
