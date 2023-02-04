package com.icabot.ToDoList.services;

import com.icabot.ToDoList.dto.TaskDto;
import com.icabot.ToDoList.model.Header;
import com.icabot.ToDoList.model.Task;
import com.icabot.ToDoList.repository.HeaderRepository;
import com.icabot.ToDoList.repository.TaskRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        Optional<Header> headerFromDb = headerRepository.findById(headerId);
        Task taskSave = createNewTask(task, headerFromDb);
        Task resDb = taskRepository.save(taskSave);

        log.info("Task saved in DB with headerId" + headerId);
        log.info("Task saved : " + resDb);

        if (resDb == null) {
            return false;
        }
        return true;
    }

    private static Task createNewTask(TaskDto task, Optional<Header> headerFromDb) {
        Task taskSave = new Task();
        taskSave.setHeader(headerFromDb.get());
        taskSave.setTask(task.getTask());
        taskSave.setCompletedTask(task.getCompletedTask());
        return taskSave;
    }

    public void deleteTask(long taskId) {
        taskRepository.deleteById(taskId);
    }

    public List<TaskDto> getTaskByHeaderId(long headerId) {
        List<TaskDto> taskDtos = new ArrayList<>();
        headerRepository.findById(headerId).get().getTasks()
                .forEach(a -> taskDtos.add(TaskDto.builder()
                        .taskId(a.getTaskId())
                        .task(a.getTask())
                        .completedTask(a.getCompletedTask())
                        .build()));
        return taskDtos;
    }

}
