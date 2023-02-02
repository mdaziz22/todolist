package com.icabot.ToDoList.repository;

import com.icabot.ToDoList.model.Header;
import com.icabot.ToDoList.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HeaderRepository extends JpaRepository<Header, Long> {

}
