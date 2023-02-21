package com.icabot.ToDoList.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String userName;
    private String name;
    private String password;
}
