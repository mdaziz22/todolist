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

@Service
public class TaskService {

    @Autowired
    HeaderRepository headerRepository;
    @Autowired
    TaskRepository taskRepository;

    public void createTask(Task task) {
        Header header = task.getHeader();
        headerRepository.save(header);
        taskRepository.save(task);
    }

    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    /*public List<Task> getTaskByHeader(String header) {
        return taskRepository.findByHeader(header);
    }*/
}
