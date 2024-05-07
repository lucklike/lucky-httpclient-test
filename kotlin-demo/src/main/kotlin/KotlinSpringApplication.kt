package com.crh.generate

import io.github.lucklike.httpclient.annotation.EnableLuckyHttpClient
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@EnableLuckyHttpClient
@SpringBootApplication
open class KotlinApplication {

}

fun main(array: Array<String>) {
    SpringApplication.run(KotlinApplication::class.java, *array);
}