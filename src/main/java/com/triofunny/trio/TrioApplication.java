package com.triofunny.trio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class TrioApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrioApplication.class, args);
    }
}
