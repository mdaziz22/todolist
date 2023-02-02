package com.icabot.ToDoList.services;

import com.icabot.ToDoList.model.Header;
import com.icabot.ToDoList.model.Task;
import com.icabot.ToDoList.repository.HeaderRepository;
import com.icabot.ToDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeaderService {

    @Autowired
    private HeaderRepository headerRepository;

    @Autowired
    private TaskRepository taskRepository;

    public void createHeader(Header header) {
        headerRepository.save(header);
    }

    public void addTask(long id, Task task) {
        var header = headerRepository.findById(id);
        if(!header.isEmpty()){
            taskRepository.save(task);
        }
    }
}
