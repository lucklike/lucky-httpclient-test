package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.proxy.annotations.ConvertProhibition;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.JavaBody;
import com.luckyframework.httpclient.proxy.annotations.Put;
import com.luckyframework.httpclient.proxy.annotations.SpElSelect;
import com.luckyframework.httpclient.proxy.annotations.StaticCookie;
import com.luckyframework.httpclient.proxy.annotations.URLEncoder;
import io.github.lucklike.User;
import io.github.lucklike.httpclient.annotation.HttpClient;
import io.github.lucklike.httpclient.annotation.HttpClientComponent;

@URLEncoder
@SpElSelect("#{$body$.data}")
@HttpClientComponent
public interface JavaSerializableAPI2 extends ServerBootApi {

    @Get("/java/getObject")
    User getObject();

    @Put("/java/putObject")
    User putObject(@JavaBody User user);

    @ConvertProhibition
    @StaticCookie({"fu=kang", "你好=世界"})
    @Get("/java/test")
    void test();
}
