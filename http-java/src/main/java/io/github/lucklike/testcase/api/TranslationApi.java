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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/17 23:11
 */
public interface TranslationApi extends FanYiGouApi {

    @Post("/TranslateApi/api/trans")
    @SpElSelect("#{$this$.fromJson($body$).data.transResult}")
    @StaticQuery({
            "appid=#{appid}",
            "from=zh", "to=en",
            "nonce_str=#{nonce_str}",
            "token=#{" +
                    "$this$.getToken({" +
                            "to: 'en', " +
                            "from: 'zh', " +
                            "appid: appid, " +
                            "nonce_str: nonce_str, " +
                            "privatekey: privatekey, " +
                            "text: text})" +
                    "}"
    })
    String trans(String text);

}
