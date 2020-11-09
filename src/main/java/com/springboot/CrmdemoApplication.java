package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class CrmdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmdemoApplication.class, args);
    }

}
