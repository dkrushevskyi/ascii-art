package com.asciiart.asciiart.service;

public interface AsciiGeneratorService {

    String generateFromText(String text, String character, int size, boolean isOutline);
}
