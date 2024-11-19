package com.pariyajafari.todolistproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ToDoListProjectApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ToDoListProjectApplication.class);
    }

    public static void main(String[] args) {

        SpringApplication.run(ToDoListProjectApplication.class, args);
    }

}
