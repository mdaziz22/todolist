package com.icabot.ToDoList.repository;

import com.icabot.ToDoList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
