package com.vishal.restservices.service;

import com.vishal.restservices.entity.User;
import com.vishal.restservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long Id){
        return userRepository.findById(Id);
    }

    public void deleteUserById(Long Id){
        userRepository.deleteById(Id);
    }

    public User updateUserById(Long Id, User user){
        user.setId(Id);
        return userRepository.save(user);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
