package com.icabot.ToDoList.controller;

import com.icabot.ToDoList.dto.UserDto;
import com.icabot.ToDoList.model.User;
import com.icabot.ToDoList.repository.UserRepository;
import com.icabot.ToDoList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> getUsers(){
        List<User> list = Arrays.asList(
                User.builder().userName("userName1")
                        .name("name1")
                        .password("pass1")
                        .build(),
                User.builder().userName("userName2")
                        .name("name2")
                        .password("pass12")
                        .build()
        );
        List<User> listFromDb = userRepository.saveAll(list);
        return new  ResponseEntity<List<User>>(listFromDb, HttpStatus.OK);
    }
    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto){
        User userFromDB = userService.createUser(userDto);
        if(userFromDB == null){
        return new ResponseEntity<User>(null);
        }

        return new ResponseEntity<User>(userFromDB, HttpStatus.OK);
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUser(@PathVariable long userId ){
       User userFromDB =  userService.getUser(userId);
        if(userFromDB == null){
            return new ResponseEntity<User>(null);
        }

        return new ResponseEntity<User>(userFromDB, HttpStatus.OK);
    }
}
