package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.JavaBody;
import com.luckyframework.httpclient.proxy.annotations.Put;
import com.luckyframework.httpclient.proxy.annotations.QueryParam;
import com.luckyframework.httpclient.proxy.annotations.SpElSelect;
import com.luckyframework.httpclient.proxy.annotations.StaticCookie;
import com.luckyframework.httpclient.proxy.annotations.URLEncoder;
import io.github.lucklike.User;
import io.github.lucklike.httpclient.annotation.HttpClient;

@URLEncoder
@HttpClient("${API.java}")
public interface JavaSerializableAPI {

    @Get("getObject")
    User getObject();


    @Put("putObject")
    @SpElSelect("#{$body$.data}")
    User putObject(@JavaBody User user);

    @StaticCookie({"fu=kang","你好=世界"})
    @Get("test")
    void test();
}
