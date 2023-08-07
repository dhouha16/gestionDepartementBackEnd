package com.example.appbackend.converter;

import com.example.appbackend.dto.GetUserDto;
import com.example.appbackend.dto.UserDepartementDto;
import com.example.appbackend.dto.UsersDto;
import com.example.appbackend.entities.Users;
import com.example.appbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    @Autowired
    UsersRepository usersRepository;
   public GetUserDto entityToDto(Users user){
       GetUserDto userDto=new GetUserDto();
       userDto.setId(user.getId());
        userDto.setStatus(user.isStatus());
        userDto.setEmail(user.getEmail());
        userDto.setLastName(user.getLastName());
        userDto.setFirstName(user.getFirstName());
        return userDto;
    }

    public List<GetUserDto> entityToDto(List<Users> users){
        return users.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }


}
