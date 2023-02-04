package com.icabot.ToDoList.controller;

import com.icabot.ToDoList.dto.HeaderDto;
import com.icabot.ToDoList.dto.TaskDto;
import com.icabot.ToDoList.model.Header;
import com.icabot.ToDoList.model.Task;
import com.icabot.ToDoList.services.HeaderService;
import com.icabot.ToDoList.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private HeaderService headerService;

   /* @PostMapping("/createTask")
    public void createTask(@RequestBody Task task){
        taskService.createTask(task);
    }*/

   /* @PostMapping("/createHeader")
    public void createHeader(@RequestBody Header header){
        headerService.createHeader(header);
    }*/

    /*@PostMapping("/addTask")
    public void addTask(@RequestParam long id, @RequestBody Task task){
        headerService.addTask(id,task);
    }*/

    @GetMapping("/getAllHeader")
    public List<HeaderDto> getAllTask(){
        List<HeaderDto> listHeader = headerService.getAllHeader();
        return listHeader;
    }

    @GetMapping("/getTaskByHeaderId/{headerId}")
    public List<Task> getTaskByHeaderId(@PathVariable long headerId){
        return null;
    }

    /*@PostMapping("/createTaskWithHeaderId/{headerId}")
    public void createTaskWithHeaderId(@RequestBody Task task){
        taskService.
    }*/

    @DeleteMapping("/deleteTask/{taskId}")
    public void deleteTask(@PathVariable long taskId){
        taskService.deleteTask(taskId);

    }

    //this controller creates only the header
    @PostMapping("/createHeader")
    public void createHeader(@RequestBody Header header){
        headerService.saveHeader(header);
    }

    //controller that creates task based on the headerId provided by the frontend
    @PostMapping("/createTask/{headerId}")
    public ResponseEntity<HttpStatus> createTask(@PathVariable long headerId, @RequestBody TaskDto task){

        boolean resTaskService = taskService.createTask(headerId,task);
        if(resTaskService){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    /*@GetMapping("/getTaskByHeader")
    public List<Task> getTaskByHeader(@RequestParam String header){
        return taskService.getTaskByHeader(header);
    }
*/

}
