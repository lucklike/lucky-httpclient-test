package io.github.lucklike.serverboot.controller;

import com.luckyframework.common.StringUtils;
import io.github.lucklike.resp.Result;
import io.github.lucklike.serverboot.jwt.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限相关的测试接口
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/2 21:32
 */
@Slf4j
@RestController
@RequestMapping("auth")
public class AuthorityController {

    @GetMapping("/getToken")
    public Result<String> getToken(String userName, HttpServletResponse response) {
        // 创建一个 Cookie 对象
        Cookie cookie = new Cookie("username", "john_doe");
        cookie.setMaxAge(3600); // 设置 Cookie 的有效期为1小时
        cookie.setPath("/"); // 设置 Cookie 的路径

        // 创建一个 Cookie 对象
        Cookie cookie2 = new Cookie("username2", "john_doe2");
        cookie2.setMaxAge(3600); // 设置 Cookie 的有效期为1小时
        cookie2.setPath("/2"); // 设置 Cookie 的路径

        // 添加 Cookie 到响应中
        response.addCookie(cookie);
        response.addCookie(cookie2);
        return Result.success(JWTUtils.createJWT(userName, "lucky", 20000));
    }

    @GetMapping("helloUser")
    public Result<?> helloUser(HttpServletRequest request) {
        String token = request.getHeader("X-Auth-Token");
        if (StringUtils.hasText(token)) {
            try {
                return Result.success(StringUtils.format("welcome {}", JWTUtils.parseJWT(token).getSubject()));
            } catch (Exception e) {
                log.error("Description token parsing failed", e);
                return Result.error("403", "Description token parsing failed");
            }

        }
        return Result.error("500", "Invalid token");
    }

}
