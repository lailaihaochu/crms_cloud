package com.crms.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class UserCenterApplication {

    public static void main(String[] args) {
        try{
            SpringApplication.run(UserCenterApplication.class, args);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
