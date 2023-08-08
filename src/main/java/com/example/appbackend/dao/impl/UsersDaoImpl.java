package com.example.appbackend.dao.impl;

import com.example.appbackend.converter.UserConverter;
import com.example.appbackend.dao.UsersDao;
import com.example.appbackend.dto.UserDepartementDto;
import com.example.appbackend.dto.UsersDto;
import com.example.appbackend.entities.Departement;
import com.example.appbackend.entities.Users;
import com.example.appbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class UsersDaoImpl implements UsersDao, UserDetailsService {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    UserConverter userConverter;
    @Override
    public boolean addUser(UsersDto usersDto) {
        Users user=new Users();
        user.setFirstName(usersDto.getFirstName());
        user.setLastName(usersDto.getLastName());
        user.setEmail(usersDto.getEmail());
        user.setDepartement(usersDto.getDepartement());
        user.setStatus(usersDto.isStatus());
        user.setPassword(passwordEncoder.encode(usersDto.getPassword()));
        usersRepository.save(user);
        return true;
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public Users getUserById(Long id) {
        if(usersRepository.findById(id).isPresent())
        return usersRepository.findById(id).get();
        else return null;
    }

    @Override
    public boolean updateUser(Long id, UsersDto usersDto) {
        if(usersRepository.findById(id).isPresent()) {
            Users user=usersRepository.findById(id).get();
            user.setFirstName(usersDto.getFirstName());
            user.setLastName(usersDto.getLastName());
            user.setEmail(usersDto.getEmail());
            user.setDepartement(usersDto.getDepartement());
            user.setStatus(usersDto.isStatus());
            usersRepository.save(user);
            return true;
        }else
            return false;
    }

    @Override
    public boolean deleteUser(Long id) {
        if(usersRepository.findById(id).isPresent()) {
            usersRepository.deleteById(id);
            return true;
        }else
            return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = null;
        Users user = usersRepository.findByEmail(username);
        if ((user != null) ){
            Collection<SimpleGrantedAuthority> autorities = new ArrayList<>();
              autorities.add(new SimpleGrantedAuthority(user.getRole().getNomRole()));
            userDetails= new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), autorities);
            System.out.println("user {} password" + userDetails.getUsername());
        }
        return userDetails;
    }
}
