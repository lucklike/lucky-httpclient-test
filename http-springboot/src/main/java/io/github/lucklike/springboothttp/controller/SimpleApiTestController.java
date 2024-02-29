package io.github.lucklike.springboothttp.controller;

import io.github.lucklike.springboothttp.api.SimpleApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SimpleApiTestController {

    @Resource
    private SimpleApi api;


    @GetMapping("sayHello")
    public String sayHello(String name) throws Exception {
        return api.sayHello(name).get();
    }

    @RequestMapping("hi/{name}")
    public String hi(@PathVariable("name") String name){
        return api.hi(name);
    }
}
