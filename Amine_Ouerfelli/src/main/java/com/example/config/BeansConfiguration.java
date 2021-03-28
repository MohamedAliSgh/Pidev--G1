package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration

@ComponentScan("com.example")
@ComponentScan("com.example.service")
@ComponentScan("com.example.control")
@ComponentScan("com.example.repository")
public class BeansConfiguration {

}
