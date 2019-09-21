package com.wonders;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.wonders.mapper")
public class DubboPersistantApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboPersistantApplication.class, args);
    }

}
