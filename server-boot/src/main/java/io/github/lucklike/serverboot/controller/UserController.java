package io.github.lucklike.serverboot.controller;

import io.github.lucklike.User;
import io.github.lucklike.resp.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/12 00:46
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("get")
    public Result<User> getUser() {
        User user = new User();
        user.setId(1);
        user.setUsername("Jack付款");
        user.setPassword("PA$$W0RD");
        user.setAge(27);
        user.setEmail("1814378890@qq.com");
        return Result.success(user);
    }

    @PutMapping("put")
    public void put(User user) {
        System.out.println(user);
    }

    @PostMapping("post")
    public void post(@RequestBody User user) {
        System.out.println(user);
    }
}
