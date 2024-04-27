package io.github.lucklike.springboothttp.api;

import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.NotHttpParam;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.StaticHeader;
import com.luckyframework.httpclient.proxy.spel.SpELVar;
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
@SpELVar("app-id=#{#SM4('${fanYiGou.sm4.appId}')}")
@HttpClientComponent
public interface TranslationApi extends FanYiGouApi {

    @Post("/TranslateApi/api/trans?from=zh&to=en")
    String trans(String text);

    @Post("/TranslateApi/api/trans?from=zh&to=en")
    Future<String> syncTrans(String text);

    @SM4
    @Get("/Test/v1/")
    String ttt(String sm4AppKey, String sm4PrivateKey);
}
