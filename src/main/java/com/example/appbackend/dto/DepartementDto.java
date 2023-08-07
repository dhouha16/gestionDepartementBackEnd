package com.example.appbackend.dto;

import com.example.appbackend.entities.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
public class DepartementDto {
    private Long id;
    private String firstName;
    private List<Users> users ;
}
