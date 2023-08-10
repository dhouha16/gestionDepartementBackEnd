package com.example.appbackend.controlleur;

import com.example.appbackend.dto.*;
import com.example.appbackend.security.filter.JwtToken;
import com.example.appbackend.service.ProjectService;
import com.example.appbackend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@CrossOrigin("*")
@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    TaskService taskService;
    @JwtToken
    @PostMapping("/{id}")
    public ResponseEntity<Object> addTasks(@PathVariable Long id ,@RequestBody GetProjectDto getProjectDto) {
        if (taskService.addTasksByProjectsId(id,getProjectDto)==true) {

            return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap(
                    "message","project created"));

        } else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(Collections.singletonMap(
                    "message", "project not created"));

    }
    @JwtToken
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTasks(@PathVariable Long id ,@RequestBody PostTaskDto postTaskDto) {
        if (taskService.updateTask(id,postTaskDto)==true) {

            return ResponseEntity.status(HttpStatus.CREATED).body(Collections.singletonMap(
                    "message","tasks update"));

        } else
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(Collections.singletonMap(
                    "message", "tasks not updated"));

    }
    @JwtToken
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProjectTasks(@PathVariable Long id){
        ProjectTasksDto projectTasksDto=taskService.getProjectTasks(id);
        if(projectTasksDto!=null )
            return ResponseEntity.status(HttpStatus.OK).body(projectTasksDto);
        else
            return ResponseEntity.status(HttpStatus.OK).body( new Object());
    }
}
