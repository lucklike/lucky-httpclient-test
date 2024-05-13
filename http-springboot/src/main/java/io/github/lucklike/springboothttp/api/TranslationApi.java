package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.HttpExec;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.QueryParam;
import io.github.lucklike.httpclient.annotation.HttpClientComponent;
import io.github.lucklike.springboothttp.api.spel.function.SM4;

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
    String trans(@QueryParam String text);

    @Post("/TranslateApi/api/trans?#{en ? 'from=zh&to=en' : 'from=en&to=zh'}")
    Future<String> trans2(@QueryParam String text, boolean en);

    @SM4
    @Get("/Test/v1/")
    String ttt(String sm4AppKey, String sm4PrivateKey);
}
