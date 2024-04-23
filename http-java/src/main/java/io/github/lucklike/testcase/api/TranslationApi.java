package io.github.lucklike.testcase.api;

import com.luckyframework.httpclient.proxy.annotations.ConvertProhibition;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.Post;

/**
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/17 23:11
 */
public interface TranslationApi extends FanYiGouApi {

    @Post("/TranslateApi/api/trans?from=zh&to=en")
    String trans(String text);

    @ConvertProhibition
    @Get("http://localhost:8081/protobuf/get?name=Jack")
    String getName();
}
