package com.example.appbackend.controlleur;

import com.example.appbackend.dto.ProjectDto;
import com.example.appbackend.dto.RoleDto;
import com.example.appbackend.security.filter.JwtToken;
import com.example.appbackend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
@CrossOrigin("*")
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @JwtToken
    @PostMapping("")
    public ResponseEntity<Object> addRole(@RequestBody RoleDto roleDto) {
        if (roleService.addRole(roleDto)==true) {
            return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap(
                    "message","role created"));
        } else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(Collections.singletonMap(
                    "message", "role not created"));

    }
}
