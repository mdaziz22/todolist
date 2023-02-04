package com.icabot.ToDoList.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {
    private long taskId;
    private String task;
    private Boolean completedTask;

}
