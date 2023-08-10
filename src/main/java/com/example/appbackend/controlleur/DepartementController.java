package com.example.appbackend.controlleur;

import com.example.appbackend.dto.DepartementDto;
import com.example.appbackend.dto.GetDepartementProjects;
import com.example.appbackend.dto.UserDepartementDto;
import com.example.appbackend.entities.Departement;
import com.example.appbackend.security.filter.JwtToken;
import com.example.appbackend.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/departement")
public class DepartementController {

    @Autowired
    DepartementService departementService;
    @JwtToken
    @PostMapping("")
    public ResponseEntity<Object> addDepartement(@RequestBody DepartementDto departementDto) {
            if (departementService.addDepatement(departementDto)==true) {

                return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap(
                        "message","departement created"));

            } else
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(Collections.singletonMap(
                        "message", "departement not created"));

    }
    @JwtToken
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateDepartement(@PathVariable Long id,@RequestBody DepartementDto departementDto) {
        boolean status =departementService.updateDepatement(id,departementDto);
            if (status==true) {

                return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap(
                        "message","departement updated"));


            } else
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(Collections.singletonMap(
                        "message", "departement not updated"));
    }
    @JwtToken
    @GetMapping("")
    public ResponseEntity<Object> getAllDepartement(){
        List<Departement>allList=departementService.getAllDepartement();
        if(allList!=null )
            return ResponseEntity.status(HttpStatus.OK).body(allList);
        else
            return ResponseEntity.status(HttpStatus.OK).body( new ArrayList<>());

    }
    @JwtToken
    @GetMapping("/{id}")
    public ResponseEntity<Object> getDepartementById(@PathVariable Long id){
        Departement departement=departementService.getDepartementById(id);
        if(departement!=null )
            return ResponseEntity.status(HttpStatus.OK).body(departement);
        else
            return ResponseEntity.status(HttpStatus.OK).body( new ArrayList<>());
    }
    @JwtToken
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDepartement(@PathVariable Long id){
        if(departementService.deleteDepartement(id))
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message", "departement is delete with success"));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    Collections.singletonMap("message", "error"));
    }
    @JwtToken
    @GetMapping("/users/{id}")
    public ResponseEntity<Object> getUsersDepartementById(@PathVariable Long id){
        UserDepartementDto departement=departementService.getUsersByDepartementId(id);
        if(departement!=null )
            return ResponseEntity.status(HttpStatus.OK).body(departement);
        else
            return ResponseEntity.status(HttpStatus.OK).body( new Object());
    }
    @JwtToken
    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUsersDepartement(@PathVariable Long id,@RequestBody DepartementDto departementDto) {
        boolean status =departementService.updateUsersByDepartementId(departementDto,id);
        if (status==true) {
            return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap(
                    "message","departement updated"));
        } else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(Collections.singletonMap(
                    "message", "departement not updated"));
    }
    @JwtToken
    @GetMapping("/projects/{id}")
    public ResponseEntity<Object> getProjectsDepartement(@PathVariable Long id){
        GetDepartementProjects departement=departementService.getProjectBydepartmentId(id);
        if(departement!=null )
            return ResponseEntity.status(HttpStatus.OK).body(departement);
        else
            return ResponseEntity.status(HttpStatus.OK).body( new Object());
    }

}
