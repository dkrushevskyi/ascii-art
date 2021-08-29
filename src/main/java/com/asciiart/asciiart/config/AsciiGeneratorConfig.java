package com.asciiart.asciiart.config;

import com.asciiart.asciiart.generator.TextGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AsciiGeneratorConfig {

    @Bean
    public TextGenerator textGenerator(){
        return new TextGenerator();
    }
}
