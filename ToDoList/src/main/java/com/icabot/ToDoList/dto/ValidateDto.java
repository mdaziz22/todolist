package com.icabot.ToDoList.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidateDto {

    private String errorMessage;
    private Boolean isSuccess;
}
