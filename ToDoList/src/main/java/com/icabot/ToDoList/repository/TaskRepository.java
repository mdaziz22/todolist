package com.icabot.ToDoList.repository;

import com.icabot.ToDoList.model.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findByHeader(String header);
}
