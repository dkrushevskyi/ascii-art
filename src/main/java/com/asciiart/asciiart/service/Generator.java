package com.asciiart.asciiart.service;

public interface Generator<T> {

    String generate(T source);
}
