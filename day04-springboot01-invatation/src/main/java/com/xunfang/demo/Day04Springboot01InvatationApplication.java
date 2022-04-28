package com.xunfang.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xunfang.demo.dao")
public class Day04Springboot01InvatationApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day04Springboot01InvatationApplication.class, args);
    }

}
