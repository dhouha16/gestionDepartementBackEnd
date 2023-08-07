package com.example.appbackend.dao.impl;

import com.example.appbackend.converter.ProjectConverter;
import com.example.appbackend.dao.TaskDao;
import com.example.appbackend.dto.GetProjectDto;
import com.example.appbackend.dto.PostTaskDto;
import com.example.appbackend.dto.ProjectTasksDto;
import com.example.appbackend.dto.TaskDto;
import com.example.appbackend.entities.Project;
import com.example.appbackend.entities.Task;
import com.example.appbackend.repository.ProjectRepository;
import com.example.appbackend.repository.TaskRepository;
import com.example.appbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaskDaoImpl implements TaskDao {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    TaskRepository taskRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    ProjectConverter projectConverter;

    @Override
    public boolean addTasksByProjectsId(Long id, GetProjectDto getProjectDto) {
        boolean status=false;
        if(projectRepository.findById(id).isPresent()){
            for(int i=0;i<getProjectDto.getTasks().size();i++){
                Task task=new Task();
                task.setDescription(getProjectDto.getTasks().get(i).getDescription());
                task.setProject(projectRepository.findById(id).get());
                task.setUsers(usersRepository.findById(getProjectDto.getTasks().get(i).getUsers().getId()).get());
                taskRepository.save(task);
                status=true;
            }
        }
        return status;
    }

    @Override
    public boolean updateTask(Long id, PostTaskDto taskDto) {
        boolean status=false;
        if(taskRepository.findById(id).isPresent()){
            Task task=taskRepository.findById(id).get();
            task.setDescription(taskDto.getDescription());
            task.setUsers(taskDto.getUsers());
            taskRepository.save(task);
            status=true;
        }
        return status;
    }

    @Override
    public ProjectTasksDto getProjectTasks(Long id) {
        Project project=projectRepository.findById(id).get();
        return   projectConverter.projectTasksEntityToDto(project);
    }


}
