package com.icabot.ToDoList.services;

import com.icabot.ToDoList.dto.UserDto;
import com.icabot.ToDoList.model.User;
import com.icabot.ToDoList.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(UserDto userDto) {

        try{
            User userFromDB =userRepository.save(
                    User.builder()
                            .userName(userDto.getUserName())
                            .name(userDto.getName())
                            .password(userDto.getPassword())
                            .build());
            return userFromDB;
        }
        catch (Exception e){
            return null;
        }
    }

    public User getUser(long userId) {
        try{
            User userFromDb = userRepository.findById(userId).orElseThrow();
            return userFromDb;
        }
        catch (Exception e ){
            return null;
        }




    }
}
