package com.icabot.ToDoList.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HeaderDto {
    private long userId;
    private long headerId;
    private String header;
    private Date date;
}
