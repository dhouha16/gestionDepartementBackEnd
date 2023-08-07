package com.example.appbackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    @OneToMany(mappedBy = "departement" ,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Users> users ;
    @OneToMany(mappedBy = "departement" ,cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Project> projects ;

    public Departement(Long id, String firstName, List<Users> users) {
        this.id = id;
        this.firstName = firstName;
        this.users = users;
    }
}
