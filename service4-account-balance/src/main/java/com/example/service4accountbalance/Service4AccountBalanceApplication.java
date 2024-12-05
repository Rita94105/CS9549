package com.example.service4accountbalance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // 启用 Feign
public class Service4AccountBalanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Service4AccountBalanceApplication.class, args);
    }

}
