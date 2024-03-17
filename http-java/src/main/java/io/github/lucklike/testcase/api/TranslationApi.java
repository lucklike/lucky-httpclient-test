package io.github.lucklike.testcase.api;

import cn.hutool.crypto.digest.DigestUtil;
import com.luckyframework.common.NanoIdUtils;
import com.luckyframework.common.StringUtils;
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.Post;
import com.luckyframework.httpclient.proxy.annotations.SpELVar;
import com.luckyframework.httpclient.proxy.annotations.SpElSelect;
import com.luckyframework.httpclient.proxy.annotations.StaticQuery;
import com.luckyframework.httpclient.proxy.context.Context;
import com.luckyframework.serializable.SerializationSchemeFactory;

/**
 * 1a41b4548098008dd73403d47c28055ac1af3969
 * 1710693968662
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/17 23:11
 */
@SpELVar({
        "appid=1710693968662",
        "privatekey=1a41b4548098008dd73403d47c28055ac1af3969",
        "nonce_str=huihuhihui"
})
@DomainName("https://www.fanyigou.com")
public interface TranslationApi {

    @SpElSelect("#{$this$.fromJson($body$).data.transResult}")
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

    default String nanoId(){
        return NanoIdUtils.randomNanoId();
    }
}
