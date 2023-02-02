package com.icabot.ToDoList.dto;

import com.icabot.ToDoList.model.Task;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Payload {
    private long headerId;
    private String header;
    private Date date;
    private List<TaskDto> tasksdto;
}
