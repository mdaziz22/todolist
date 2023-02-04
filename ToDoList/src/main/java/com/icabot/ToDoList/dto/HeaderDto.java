package com.icabot.ToDoList.dto;

import lombok.*;

import java.util.Date;

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
