package com.icabot.ToDoList.controller;

import com.icabot.ToDoList.model.TaskEntity;
import com.icabot.ToDoList.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/createTask")
    public void createTask(@RequestParam String header,
                           @RequestParam String task){
        taskService.createTask(header,task);
    }

    @GetMapping("/getAllTask")
    public List<TaskEntity> getAllTask(){
        return taskService.getAllTask();
    }

    @GetMapping("/getTaskByHeader")
    public List<TaskEntity> getTaskByHeader(@RequestParam String header){
        return taskService.getTaskByHeader(header);
    }


}
