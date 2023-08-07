package com.example.appbackend.controlleur;

import com.example.appbackend.dto.*;
import com.example.appbackend.service.DepartementService;
import com.example.appbackend.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<Object> addProject(@RequestBody ProjectDto projectDto) {
        if (projectService.addProjectBydepartmentId(projectDto)==true) {

            return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap(
                    "message","project created"));

        } else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(Collections.singletonMap(
                    "message", "project not created"));

    }
    @GetMapping("users/{id}")
    public ResponseEntity<Object> getusersByProject(@PathVariable Long id){
        List<GetUserDto> usersDto=projectService.getUsersByProjectsAnddepartmentId(id);
        if(usersDto!=null )
            return ResponseEntity.status(HttpStatus.OK).body(usersDto);
        else
            return ResponseEntity.status(HttpStatus.OK).body( new ArrayList<>());
    }
}
