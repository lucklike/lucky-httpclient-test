package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.proxy.annotations.ConvertProhibition;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.JavaBody;
import com.luckyframework.httpclient.proxy.annotations.Put;
import com.luckyframework.httpclient.proxy.annotations.ResponseSelect;
import com.luckyframework.httpclient.proxy.annotations.StaticCookie;
import com.luckyframework.httpclient.proxy.annotations.URLEncoder;
import io.github.lucklike.User;
import io.github.lucklike.httpclient.annotation.HttpClient;

@URLEncoder
@ResponseSelect("#{$body$.data}")
@HttpClient("${API.java}")
public interface JavaSerializableAPI {


    @Get("getObject")
    User getObject();

    @Put("putObject")
    User putObject(@JavaBody User user);

    @ConvertProhibition
    @StaticCookie({"fu=kang", "你好=世界"})
    @Get("test")
    void test();
}
