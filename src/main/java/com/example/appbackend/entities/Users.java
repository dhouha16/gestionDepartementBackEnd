package com.example.appbackend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

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
    @ManyToOne
    @JoinColumn(name = "departement_id")

    private Departement departement;
    @OneToMany(mappedBy = "users")
    @JsonManagedReference
    private List<Task> tasks ;

    public Users(Long id, String firstName, String lastName, String email, Departement departement) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.departement = departement;
    }
}
