package com.example.demo.config;

import com.demo.common.config.FrameworkConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Import({
        FrameworkConfig.class
})
public class Initial implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("|-------------------------------------------|");
        log.info("               service RUN");
        log.info("|-------------------------------------------|");
    }
}
