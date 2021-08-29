package com.asciiart.asciiart.generator;

public interface Generator<T> {

    String generate(T source, String character, int size, boolean outline);
}
