package com.example.demo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@EnableBinding({DemoBindings.class})
@Configuration
public class Config {
}
