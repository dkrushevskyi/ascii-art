package com.asciiart.asciiart.service;

import com.asciiart.asciiart.controller.dto.GenerateTextRequestDto;

public interface AsciiGeneratorService {

    String generateFromText(GenerateTextRequestDto generateTextRequestDto);
}
