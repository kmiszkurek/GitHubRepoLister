package com.example.githubrepolister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.githubrepolister.client")
public class GitHubRepoListerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GitHubRepoListerApplication.class, args);
    }

}
