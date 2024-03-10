package io.github.lucklike.serverboot.controller;

import com.luckyframework.common.StringUtils;
import io.github.lucklike.resp.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * Cookie测试类
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/8 22:29
 */
@RestController
@RequestMapping("cookie")
public class SessionController {


    @GetMapping("login")
    public Result<String> login(String user, HttpSession session){

        session.setAttribute("user", user);
        session.setAttribute("pass", "fgergrhytjtjk6u");
        return Result.success("ok");
    }

    @GetMapping("hello")
    public Result<String> hello(HttpSession session) {
        return Result.success(StringUtils.format("hello {}, you pass is {}",
                session.getAttribute("user"),
                session.getAttribute("pass")));
    }

    @GetMapping("set")
    public Result<String> set(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        Cookie cookie = new Cookie("key1", "/cookie/妞妞");
        cookie.setMaxAge(3*60);
        cookie.setPath("/cookie");

        // 创建一个 Cookie 对象
        Cookie cookie2 = new Cookie("key2", "/simple/");
        cookie2.setMaxAge(2*60);
        cookie2.setPath("/simple");

        // 创建一个 Cookie 对象
        Cookie cookie3 = new Cookie("key3", "all");
        cookie3.setMaxAge(60);
        cookie3.setPath("/");

        // 添加 Cookie 到响应中
        response.addCookie(cookie);
        response.addCookie(cookie2);
        response.addCookie(cookie3);
        return Result.success("success");
    }
}
