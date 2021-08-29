package com.asciiart.asciiart.service;

import com.asciiart.asciiart.generator.TextGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AsciiGeneratorServiceImpl implements AsciiGeneratorService{

    private final TextGenerator textGenerator;

    @Override
    public String generateFromText(String text, String character, int size, boolean isOutline) {
        return textGenerator.generate(text, character, size, isOutline);
    }
}
