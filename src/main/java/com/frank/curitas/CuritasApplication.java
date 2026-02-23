package com.frank.curitas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CuritasApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CuritasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
