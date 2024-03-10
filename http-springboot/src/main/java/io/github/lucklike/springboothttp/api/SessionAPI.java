package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.SpElSelect;
import io.github.lucklike.httpclient.annotation.HttpClient;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/8 22:35
 */

@SpElSelect("#{$body$.data}")
@HttpClient("${API.cookie}")
public interface SessionAPI {

    @Get("login")
    String login(String user);

    @Get("hello")
    String hello();

    @Get("set")
    String set();
}
