package com.manideep.orderservice;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderserviceApplication {

  public static void main(String[] args) {
    Dotenv dotenv = Dotenv.configure().load(); // load the env variables

    dotenv
      .entries()
      .forEach((DotenvEntry entry) ->
        System.setProperty(entry.getKey(), entry.getValue())
      ); // Set the env variables
    SpringApplication.run(OrderserviceApplication.class, args);
  }
}
