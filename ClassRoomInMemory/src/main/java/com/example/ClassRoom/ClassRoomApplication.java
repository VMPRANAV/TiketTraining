package com.example.ClassRoom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ClassRoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClassRoomApplication.class, args);
    }

}
