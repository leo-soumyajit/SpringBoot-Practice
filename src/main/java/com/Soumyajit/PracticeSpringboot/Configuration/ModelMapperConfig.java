package com.Soumyajit.PracticeSpringboot.Configuration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getMethod(){
        return new ModelMapper();
    }
}
