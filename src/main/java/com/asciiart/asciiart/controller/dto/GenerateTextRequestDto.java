package com.asciiart.asciiart.controller.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class GenerateTextRequestDto {

    @NotBlank(message = "Field can't be empty")
    private String text;
    @Size(min = 1, max = 1)
    private String character;
    @Min(value = 10)
    @Max(value = 40)
    private int size;
    private boolean outline;
}
