package com.icabot.ToDoList.services;

import com.icabot.ToDoList.dto.TaskDto;
import com.icabot.ToDoList.model.Header;
import com.icabot.ToDoList.model.Task;
import com.icabot.ToDoList.repository.HeaderRepository;
import com.icabot.ToDoList.repository.TaskRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class TaskService {

    @Autowired
    HeaderRepository headerRepository;
    @Autowired
    TaskRepository taskRepository;

    public boolean createTask(long headerId, TaskDto task) {


            Optional<Header> headerFromDb =headerRepository.findById(headerId);
            Task taskSave = new Task();
            taskSave.setHeader(headerFromDb.get());
          //  taskSave.setTaskId(task.getTaskId());
            taskSave.setTask(task.getTask());
            taskSave.setCompletedTask(task.getCompletedTask());
           Task resDb =  taskRepository.save(taskSave);

        log.info("Task saved in DB with headerId"+headerId);
        log.info("Task saved : "+resDb);

           if(resDb == null){
               return false;
           }
           return true;



    }

    public List<Header> getAllHeader() {
        List<Task> taskDB = taskRepository.findAll();
        return taskDB.stream().map(a -> a.getHeader()).collect(Collectors.toList());
    }

    public void deleteTask(long taskId) {
        taskRepository.deleteById(taskId);
    }

    public List<Task> getTaskByHeaderId(long headerId) throws NullPointerException {

            return null;

    }

    /*public List<Task> getTaskByHeader(String header) {
        return taskRepository.findByHeader(header);
    }*/
}
