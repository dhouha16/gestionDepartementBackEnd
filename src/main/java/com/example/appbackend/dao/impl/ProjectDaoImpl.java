package com.example.appbackend.dao.impl;

import com.example.appbackend.converter.UserConverter;
import com.example.appbackend.dao.ProjectDao;
import com.example.appbackend.dto.GetUserDto;
import com.example.appbackend.dto.ProjectDto;
import com.example.appbackend.dto.UsersDto;
import com.example.appbackend.entities.Departement;
import com.example.appbackend.entities.Project;
import com.example.appbackend.entities.Task;
import com.example.appbackend.entities.Users;
import com.example.appbackend.repository.DepartementRepository;
import com.example.appbackend.repository.ProjectRepository;
import com.example.appbackend.repository.TaskRepository;
import com.example.appbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDaoImpl implements ProjectDao {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public boolean addProjectBydepartmentId(ProjectDto projectDto) {
        boolean status=false;
        if(departementRepository.findById(projectDto.getDepartement().getId()).isPresent()) {
            Departement departement=departementRepository.findById(projectDto.getDepartement().getId()).get();
            Project project=new Project();
            project.setDescription(projectDto.getDescription());
            project.setName(projectDto.getName() );
            project.setDepartement(departement);
            projectRepository.save(project);
            if(!projectDto.getTasks().isEmpty()){
                for(int i=0;i<projectDto.getTasks().size();i++){
                    Task task=new Task();
                    task.setProject(project);
                    task.setDescription(projectDto.getTasks().get(i).getDescription());
                    System.out.println("----------- "+usersRepository.findById(projectDto.getTasks().get(i).getUsers().getId()).get().getLastName());
                    task.setUsers(usersRepository.findById(projectDto.getTasks().get(i).getUsers().getId()).get());
                    taskRepository.save(task);
                    status=true;
                }
            }

        }
        return status;
    }

    @Override
    public List<GetUserDto> getUsersByProjectsAnddepartmentId(Long id) {

       List<Users> listUsers=usersRepository.findAllUsersByProjectId(id);
       List<GetUserDto> dtoList=userConverter.entityToDto(listUsers);
        return dtoList;
    }
}
