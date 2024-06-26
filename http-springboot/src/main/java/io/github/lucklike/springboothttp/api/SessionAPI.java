package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.PathParam;
import com.luckyframework.httpclient.proxy.annotations.RespSelect;
import io.github.lucklike.httpclient.annotation.HttpClient;

import java.util.List;
import java.util.Map;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/8 22:35
 */

@RespSelect("#{$body$.data}")
@HttpClient("${API.cookie}")
public interface SessionAPI {

    @Get("login")
    String login(String user);

    @Get("hello")
    String hello();

    @Get("set")
    @RespSelect("#{$resp$.getResponseCookies().![{name: name, value: value}]}")
    List<Map<String, String>> set();

    @Get("${API.location}/{path}/show")
    List<String> show(@PathParam String path);
}
