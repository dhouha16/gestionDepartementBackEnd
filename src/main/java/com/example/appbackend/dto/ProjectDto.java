package com.example.appbackend.dto;

import com.example.appbackend.entities.Departement;
import com.example.appbackend.entities.Task;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
public class ProjectDto {
    private Long id;
    private String description;
    private Departement departement;
    private List<Task> tasks ;
    private String name;

}
