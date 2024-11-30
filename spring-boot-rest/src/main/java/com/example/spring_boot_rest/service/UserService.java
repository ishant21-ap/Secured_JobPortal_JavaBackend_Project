package com.example.spring_boot_rest.service;

import com.example.spring_boot_rest.model.User;
import com.example.spring_boot_rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);  //We can version also in parameters


    public User saveUser(User user) {

        //Encoding the password
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
