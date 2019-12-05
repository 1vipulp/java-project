package com.restapis.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.restapis.controllers"})
public class RestapisApplication {

  public static void main(String[] args) {
    SpringApplication.run(RestapisApplication.class, args);
  }

}
