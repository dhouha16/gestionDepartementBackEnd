package com.example.appbackend.controlleur;

import com.example.appbackend.dto.DepartementDto;
import com.example.appbackend.dto.UsersDto;
import com.example.appbackend.entities.Departement;
import com.example.appbackend.entities.Users;
import com.example.appbackend.security.filter.JwtToken;
import com.example.appbackend.service.DepartementService;
import com.example.appbackend.service.UsersService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/users")
public class UsersControllor {
    @Autowired
    UsersService usersService;
    @JwtToken
    @PostMapping("")
    public ResponseEntity<Object> addUser(@RequestBody UsersDto usersDto) {
        if (usersService.addUser(usersDto)==true) {

            return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap(
                    "message","user created"));

        } else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(Collections.singletonMap(
                    "message", "user not created"));

    }
    @JwtToken
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUsers(@PathVariable Long id,@RequestBody UsersDto usersDto) {
        boolean status =usersService.updateUser(id,usersDto);
        if (status==true) {

            return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap(
                    "message","user updated"));


        } else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(Collections.singletonMap(
                    "message", "user not updated"));
    }
    @JwtToken
    @GetMapping("")
    public ResponseEntity<Object> getAllUsers(){
        List<Users> allList=usersService.getAllUsers();
        if(allList!=null )
            return ResponseEntity.status(HttpStatus.OK).body(allList);
        else
            return ResponseEntity.status(HttpStatus.OK).body( new ArrayList<>());

    }
    @JwtToken
    @GetMapping("/{id}")
    public ResponseEntity<Object> getUserById(@PathVariable Long id){
        Users user=usersService.getUserById(id);
        if(user!=null )
            return ResponseEntity.status(HttpStatus.OK).body(user);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    Collections.singletonMap("message", "user not exist"));
    }
    @JwtToken
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable Long id){
        if(usersService.deleteUser(id))
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    Collections.singletonMap("message", "user is delete with success"));
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    Collections.singletonMap("message", "error"));
    }
}
