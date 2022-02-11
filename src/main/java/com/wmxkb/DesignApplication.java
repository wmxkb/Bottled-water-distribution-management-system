package com.wmxkb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wmxkb.mapper")
public class DesignApplication {
    public static void main(String[] args) {
        SpringApplication.run(DesignApplication.class, args);
    }

}
