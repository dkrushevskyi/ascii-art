package com.asciiart.asciiart.service;

import com.asciiart.asciiart.controller.dto.GenerateTextRequestDto;
import com.asciiart.asciiart.generator.TextGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsciiGeneratorServiceImpl implements AsciiGeneratorService{

    private final TextGenerator textGenerator;

    @Override
    public String generateFromText(GenerateTextRequestDto generateTextRequestDto) {
        return textGenerator.generate(generateTextRequestDto.getText(), generateTextRequestDto.getCharacter(),
                generateTextRequestDto.getSize(), generateTextRequestDto.isOutline());
    }
}
