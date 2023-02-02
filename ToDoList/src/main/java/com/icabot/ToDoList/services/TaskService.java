package com.icabot.ToDoList.services;

import com.icabot.ToDoList.model.Header;
import com.icabot.ToDoList.model.Task;
import com.icabot.ToDoList.repository.HeaderRepository;
import com.icabot.ToDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    HeaderRepository headerRepository;
    @Autowired
    TaskRepository taskRepository;

    public void createTask(Task task) {
        long header = task.getHeader().getHeaderId();
        if(headerRepository.existsById(header)) {
            Optional<Header> header1 =headerRepository.findById(header);
            task.setHeader(null);
            taskRepository.save(task);
        }
        else taskRepository.save(task);
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    public void deleteTask(long taskId) {
        taskRepository.deleteById(taskId);
    }

    /*public List<Task> getTaskByHeader(String header) {
        return taskRepository.findByHeader(header);
    }*/
}
