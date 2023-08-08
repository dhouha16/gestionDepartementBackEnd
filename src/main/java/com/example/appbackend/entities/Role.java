package com.example.appbackend.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomRole;
    @OneToMany( mappedBy = "role" ,cascade =CascadeType.PERSIST)
    @JsonIgnore
    private List<Users> users;

}
