package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.proxy.annotations.Post;
import io.github.lucklike.httpclient.annotation.HttpClientComponent;

import java.util.concurrent.Future;

/**
 * 翻译狗-翻译相关的API
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/17 23:11
 */
@HttpClientComponent
public interface TranslationApi extends FanYiGouApi {

    @Post("/TranslateApi/api/trans?from=zh&to=en")
    String trans(String text);

    @Post("/TranslateApi/api/trans?from=zh&to=en")
    Future<String> syncTrans(String text);
}
