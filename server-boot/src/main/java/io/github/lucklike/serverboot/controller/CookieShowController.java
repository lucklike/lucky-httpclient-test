package io.github.lucklike.serverboot.controller;

import com.luckyframework.common.StringUtils;
import io.github.lucklike.resp.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class CookieShowController {

    @GetMapping("/{path}/show")
    public Result<List<String>> show(HttpServletRequest request, @PathVariable("path") String path) {
        Cookie[] cookies = request.getCookies();
        List<String> cookieInfo = new ArrayList<>();
        cookieInfo.add(StringUtils.format("path={}/show", path));

        Stream.of(cookies == null ? new Cookie[0] : cookies).forEach(c -> {
            cookieInfo.add(StringUtils.format("{}={}", c.getName(), c.getValue()));
        });
        return Result.success(cookieInfo);
    }
}
