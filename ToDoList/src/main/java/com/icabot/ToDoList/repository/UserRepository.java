package com.icabot.ToDoList.repository;

import com.icabot.ToDoList.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
