package com.eric.redisdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RedisdemoApplication {
    Logger logger= LoggerFactory.getLogger(RedisdemoApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(RedisdemoApplication.class, args);
    }

}
