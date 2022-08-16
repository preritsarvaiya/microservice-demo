package com.microservice.microserviceinventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisAutoConfiguration;

@SpringBootApplication(exclude = ArtemisAutoConfiguration.class)
public class MicroserviceInventoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceInventoryApplication.class, args);
    }

}
