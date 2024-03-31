package io.github.lucklike.serverboot.doccase;

import com.luckyframework.common.StringUtils;
import io.github.lucklike.resp.Result;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/30 01:07
 */
@RestController
@RequestMapping("other")
public class OtherParamTestController {

    @GetMapping("path/{name}")
    public String path(@PathVariable("name") String name) {
        return StringUtils.format("Hi {}", name);
    }

    @PostMapping("header")
    public String header(@RequestHeader("X-Token") String token) {
        return StringUtils.format("token is {}", token);
    }

    @PutMapping("cookie")
    public String cookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("username".equals(cookie.getName())) {
                return StringUtils.format("cookie username is {}", cookie.getValue());
            }
        }
        return "non cookie";
    }

    @PutMapping("form")
    public Result<Map<String, Object>> form(@RequestParam Map<String, Object> formParam){
        return Result.success(formParam);
    }
}
