package com.five.group.infraestructure.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MessageContent {
    @NotBlank
    @NotNull
    @NotEmpty
    private String content;
}
