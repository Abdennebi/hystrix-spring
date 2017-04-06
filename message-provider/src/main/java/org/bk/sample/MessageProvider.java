package org.bk.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MessageProvider {
    public static void main(String[] args) {
        SpringApplication.run(MessageProvider.class, args);
    }
}
