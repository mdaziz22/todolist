package com.icabot.ToDoList.services;

import com.icabot.ToDoList.model.TaskEntity;
import com.icabot.ToDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public void createTask(String header, String task) {
        taskRepository.save(TaskEntity.builder()
                .header(header)
                .task(task)
                .date(Date.valueOf(LocalDate.now()))
                .completedTask(false)
                .build());
    }

    public List<TaskEntity> getAllTask() {
        return taskRepository.findAll();
    }

    public List<TaskEntity> getTaskByHeader(String header) {
        return taskRepository.findByHeader(header);
    }
}
