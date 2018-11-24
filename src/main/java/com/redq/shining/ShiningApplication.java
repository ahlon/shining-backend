package com.redq.shining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.redq.shining.mapper")
@SpringBootApplication
public class ShiningApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiningApplication.class, args);
    }
}
