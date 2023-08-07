package com.example.appbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String name;
    @ManyToOne
    @JoinColumn(name = "departement_id")
    private Departement departement;
    @OneToMany(mappedBy = "project" ,cascade = CascadeType.ALL)
    private List<Task> tasks ;
}
