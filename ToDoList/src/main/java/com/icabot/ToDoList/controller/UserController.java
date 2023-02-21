package com.icabot.ToDoList.controller;

import com.icabot.ToDoList.dto.UserDto;
import com.icabot.ToDoList.model.User;
import com.icabot.ToDoList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class UserController {

    @Autowired
    private UserService userService;

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
