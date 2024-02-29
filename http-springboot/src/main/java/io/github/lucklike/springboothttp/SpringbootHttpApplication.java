package io.github.lucklike.springboothttp;

import io.github.lucklike.httpclient.annotation.EnableLuckyHttpClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableLuckyHttpClient
@SpringBootApplication
public class SpringbootHttpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHttpApplication.class, args);
    }

}
