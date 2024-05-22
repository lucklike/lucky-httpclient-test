package io.lucklike.httpdemo

import io.github.lucklike.httpclient.annotation.EnableLuckyHttpClient
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@EnableLuckyHttpClient
@SpringBootApplication
open class GradleHttpApplication {
}

fun main(array: Array<String>) {
    SpringApplication.run(GradleHttpApplication::class.java, *array);
}