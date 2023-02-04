package com.icabot.ToDoList.controller;

import com.icabot.ToDoList.dto.TaskDto;
import com.icabot.ToDoList.dto.ValidateDto;
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

    /*
     * Get all task for a given headerID provided by user
     */
    @GetMapping("/getTaskByHeaderId/{headerId}")
    public ResponseEntity<List<TaskDto>> getTaskByHeaderId(@PathVariable long headerId) {
        try {
            return new ResponseEntity<>(taskService.getTaskByHeaderId(headerId), HttpStatus.OK);
        } catch (Exception ex) {
            ex.getStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * Delete task for a given taskID provided by user
     */
    @DeleteMapping("/deleteTask/{taskId}")
    public ResponseEntity<ValidateDto> deleteTask(@PathVariable long taskId) {
        try {
            taskService.deleteTask(taskId);
            return new ResponseEntity<>(ValidateDto.builder()
                    .errorMessage("TaskController: Successfully deleted Task with taskId: " + taskId)
                    .isSuccess(true)
                    .build(), HttpStatus.OK);
        } catch (Exception ex) {
            ex.getStackTrace();
            return new ResponseEntity<>(ValidateDto.builder()
                    .errorMessage("TaskController: Failed to Delete Task with taskId: " + taskId)
                    .isSuccess(false)
                    .build(), HttpStatus.BAD_REQUEST);
        }


    }

    /*
     * Create task based on the headerId provided by the user
     */
    @PostMapping("/createTaskByHeaderId/{headerId}")
    public ResponseEntity<ValidateDto> createTask(@PathVariable long headerId, @RequestBody TaskDto task) {
        try {
            taskService.createTask(headerId, task);
            return new ResponseEntity<>(ValidateDto.builder()
                    .errorMessage("TaskController: Successfully retrieved Task with taskId: " + task)
                    .isSuccess(true)
                    .build(), HttpStatus.OK);
        } catch (Exception ex) {
            ex.getStackTrace();
            return new ResponseEntity<>(ValidateDto.builder()
                    .errorMessage("TaskController: Failed to retrieve Task with taskId: " + task)
                    .isSuccess(false)
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }

}
