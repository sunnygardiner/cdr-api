package com.dcs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.dcs.*"})
public class ChargingDetailsApplication {

  

    public static void main(String[] args) throws Exception {
        new SpringApplication(ChargingDetailsApplication.class).run(args);
    }

   
    
}
