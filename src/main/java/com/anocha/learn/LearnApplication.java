package com.anocha.learn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class LearnApplication {

    public static void main(String[] args) {
        try {
            System.setProperty("spring.devtools.restart.enabled", "false");
            SpringApplication.run(LearnApplication.class, args);
        } catch (Throwable e) {
            if(e.getClass().getName().contains("SilentExitException")) {
                log.debug("Spring is restarting the main thread - See spring-boot-devtools");
            } else {
                log.error("Application crashed!", e);
            }
        }
    }

}
