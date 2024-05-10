package io.github.lucklike.testcase.api;

import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.RespSelect;
import com.luckyframework.httpclient.proxy.annotations.StaticHeader;
import com.luckyframework.httpclient.proxy.spel.SpELVar;
import io.github.lucklike.proto.DemoProto;

/**
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/17 23:11
 */
public interface TranslationApi extends FanYiGouApi {

    @SpELVar("methodName=#{$method$.getName()}")
    @StaticHeader("X-Method-Name=#{methodName}")
    @Post("/TranslateApi/api/trans?from=zh&to=en")
    String trans(String text);


    @Get("http://localhost:8081/protobuf/get?name=Jack")
    @RespSelect(expression = "#{$body$.name}", metaType = DemoProto.Demo.class)
    String getName21();
}
