package com.vishal.restservices.controller;

import com.vishal.restservices.entity.User;
import com.vishal.restservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long Id){
        return userService.getUserById(Id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable("id") Long Id){
        userService.deleteUserById(Id);
    }

    @PutMapping("/users/{id}")
    public User updateByUser(@PathVariable("id") Long Id, @RequestBody User user){
        return userService.updateUserById(Id,user);
    }

    @GetMapping("/users/byusername/{username}")
    public User findByUsername(@PathVariable("username") String username){
        return userService.findByUsername(username);
    }
}
