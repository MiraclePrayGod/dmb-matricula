package com.example.dmbconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class DmbConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmbConfigServerApplication.class, args);
    }

}
