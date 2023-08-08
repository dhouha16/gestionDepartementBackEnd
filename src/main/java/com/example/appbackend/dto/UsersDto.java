package com.example.appbackend.dto;

import com.example.appbackend.entities.Departement;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Getter
@Setter
public class UsersDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Departement departement;
    private boolean status;
    private String password;

}
