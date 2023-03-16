package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(String username, String password){
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);

        userRepository.save(user);
        return user;
    }

    public void deleteUser(int userId){
        try {
            userRepository.deleteById(userId);
        }catch (Exception e){
            throw new RuntimeException(e.toString());
        }
    }

    public User updateUser(Integer id, String password){
        User user=new User();
        try {
            user = userRepository.findById(id).get();
        }catch(Exception e){
            throw new RuntimeException(e.toString());
        }
       user.setPassword(password);
       userRepository.save(user);
       return user;
    }
}
