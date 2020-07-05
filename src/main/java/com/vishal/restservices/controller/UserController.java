package com.vishal.restservices.controller;

import com.vishal.restservices.entity.User;
import com.vishal.restservices.exceptions.UserExistsException;
import com.vishal.restservices.exceptions.UserNotFoundException;
import com.vishal.restservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

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
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder builder) throws UserExistsException {
        try{
            userService.createUser(user);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
            return new ResponseEntity<Void>(headers,HttpStatus.CREATED);

        } catch (UserExistsException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long Id) throws UserNotFoundException {
        try {
            return userService.getUserById(Id);
        } catch (UserNotFoundException ex){
            throw new  ResponseStatusException(HttpStatus.NOT_FOUND,ex.getMessage());
        }
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable("id") Long Id) throws UserNotFoundException {

        try{
            userService.deleteUserById(Id);
        } catch (UserNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }
    }

    @PutMapping("/users/{id}")
    public User updateByUser(@PathVariable("id") Long Id, @RequestBody User user) throws UserNotFoundException {
        try{
            return userService.updateUserById(Id,user);
        } catch (UserNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,ex.getMessage());
        }
    }

    @GetMapping("/users/byusername/{username}")
    public User findByUsername(@PathVariable("username") String username){
        return userService.findByUsername(username);
    }
}
