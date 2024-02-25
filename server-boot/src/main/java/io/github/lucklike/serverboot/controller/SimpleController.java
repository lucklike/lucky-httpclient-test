package io.github.lucklike.serverboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 简单请求
 * @author fukang
 * @version 1.0.0
 * @date 2024/2/24 22:50
 */
@RestController
@RequestMapping("/simple/")
public class SimpleController {

    @GetMapping("sayHello")
    public String sayHello(String name){
        return "Hello " + name;
    }

    @RequestMapping("hi/{name}")
    public String hi(@PathVariable("name") String name){
        return "Hi " + name;
    }
}
