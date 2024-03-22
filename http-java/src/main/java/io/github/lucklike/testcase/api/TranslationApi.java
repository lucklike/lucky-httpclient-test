package io.github.lucklike.testcase.api;

import cn.hutool.crypto.digest.DigestUtil;
import com.luckyframework.common.NanoIdUtils;
import com.luckyframework.common.StringUtils;
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.SpELVar;
import com.luckyframework.httpclient.proxy.annotations.SpElSelect;
import com.luckyframework.httpclient.proxy.annotations.StaticHeader;
import com.luckyframework.httpclient.proxy.annotations.StaticQuery;
import com.luckyframework.httpclient.proxy.context.Context;
import com.luckyframework.serializable.SerializationSchemeFactory;
import io.github.lucklike.util.SM4Util;

/**
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/17 23:11
 */
public interface TranslationApi extends FanYiGouApi {

    @SpElSelect("#{$this$.fromJson($body$).data.transResult}")
    @StaticHeader("abc=#{abc}")
    @StaticQuery({"from=zh", "to=en", "nonce_str=#{nonce_str}", "token=#{$this$.getToken($mc$, text)}"})
    @Post("/TranslateApi/api/trans?appid=#{appid}")
    String trans(String text);

    default String getToken(Context context, String text) {
        String stringA = StringUtils.format(
                "appid=#{appid}&" +
                        "from=zh&" +
                        "nonce_str=#{nonce_str}&" +
                        "privatekey=#{privatekey}&" +
                        "text={}&" +
                        "to=en", text);
        stringA = context.parseExpression(stringA, String.class);
        return DigestUtil.md5Hex(stringA).toUpperCase();
    }

    default Object fromJson(String jsonStr) throws Exception {
       return SerializationSchemeFactory.getJsonScheme().deserialization(jsonStr, Object.class);
    }

}
