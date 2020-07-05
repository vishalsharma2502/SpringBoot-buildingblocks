package com.vishal.restservices.service;

import com.vishal.restservices.entity.User;
import com.vishal.restservices.exceptions.UserExistsException;
import com.vishal.restservices.exceptions.UserNotFoundException;
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

    public User createUser(User user) throws UserExistsException {
        User existsUser = userRepository.findByUsername(user.getUsername());

        if(existsUser !=null){
            throw new UserExistsException("User Already Exists");
        }

        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long Id) throws UserNotFoundException {

         Optional<User> user =  userRepository.findById(Id);

         if(!user.isPresent()){
             throw new UserNotFoundException("User ID Not Found in User Repository.");
         }
         return user;

    }

    public void deleteUserById(Long Id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(Id);

        if(!user.isPresent()){
            throw new UserNotFoundException("User Not Found in User Repository, Please Enter Correct ID");
        }
        userRepository.deleteById(Id);

    }

    public User updateUserById(Long Id, User user) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findById(Id);

        if(!optionalUser.isPresent()){
            throw new UserNotFoundException("User Not Found in User Repository, Please Enter Correct ID");
        }
        user.setId(Id);
        return userRepository.save(user);
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
}
