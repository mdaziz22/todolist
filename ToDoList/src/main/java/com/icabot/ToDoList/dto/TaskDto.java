package com.icabot.ToDoList.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskDto {
    private String task;
    private Boolean completedTask;

}
