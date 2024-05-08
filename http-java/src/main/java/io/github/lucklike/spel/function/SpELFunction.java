package io.github.lucklike.spel.function;

import com.luckyframework.httpclient.proxy.dynamic.URLEncoderUtils;
import com.luckyframework.httpclient.proxy.spel.FunctionAlias;

public class SpELFunction {

    @FunctionAlias("URL_ENCODE")
    public static String urlEncode(String text) {
        return URLEncoderUtils.encode(text, "UTF-8");
    }
}
