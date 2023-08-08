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
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean status;
    private String password;
    @ManyToOne
    @JoinColumn(name = "departement_id")

    private Departement departement;
    @OneToMany(mappedBy = "users")
    @JsonManagedReference
    private List<Task> tasks ;

    @ManyToOne
    @JoinColumn(name="role")
    @JsonIgnore
    private Role role;

    public Users(Long id, String firstName, String lastName, String email, Departement departement) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.departement = departement;
    }
}
