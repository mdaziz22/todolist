package com.icabot.ToDoList.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ValidateDto {

    private String errorMessage;
    private Boolean isSuccess;
}
