package com.icabot.ToDoList.controller;

import com.icabot.ToDoList.model.Header;
import com.icabot.ToDoList.model.Task;
import com.icabot.ToDoList.services.HeaderService;
import com.icabot.ToDoList.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private HeaderService headerService;

    @PostMapping("/createTask")
    public void createTask(@RequestBody Task task){
        taskService.createTask(task);
    }

    @PostMapping("/createHeader")
    public void createHeader(@RequestBody Header header){
        headerService.createHeader(header);
    }

    @PostMapping("/addTask")
    public void addTask(@RequestParam long id, @RequestBody Task task){
        headerService.addTask(id,task);
    }

    @GetMapping("/getAllTask")
    public List<Task> getAllTask(){
        return taskService.getAllTask();
    }

    @DeleteMapping("/deleteTask/{taskId}")
    public void deleteTask(@PathVariable long taskId){
        taskService.deleteTask(taskId);

    }

    /*@GetMapping("/getTaskByHeader")
    public List<Task> getTaskByHeader(@RequestParam String header){
        return taskService.getTaskByHeader(header);
    }
*/

}
