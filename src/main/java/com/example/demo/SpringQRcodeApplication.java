package com.example.demo;

import com.demo.common.config.FrameworkConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({FrameworkConfig.class})
@SpringBootApplication
public class SpringQRcodeApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringQRcodeApplication.class, args);
    }
}
