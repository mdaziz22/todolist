package com.icabot.ToDoList.dto;

import com.icabot.ToDoList.model.Task;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HeaderDto {
    private long headerId;
    private String header;
    private Date date;
}
