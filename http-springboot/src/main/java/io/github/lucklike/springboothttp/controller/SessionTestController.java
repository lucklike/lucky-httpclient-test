package io.github.lucklike.springboothttp.controller;

import io.github.lucklike.springboothttp.api.SessionAPI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/8 22:38
 */
@RestController
@RequestMapping("cookie")
public class SessionTestController {

    @Resource
    private SessionAPI api;

    @GetMapping("login")
    public String login(String name) {
        return api.login(name);
    }

    @GetMapping("hello")
    public String hello() {
        return api.hello();
    }

    @GetMapping("set")
    public List<Map<String, String>> set() {
        return api.set();
    }

    @GetMapping("/{path}/show")
    public List<String> show(@PathVariable("path") String path) {
        return api.show(path);
    }
}
