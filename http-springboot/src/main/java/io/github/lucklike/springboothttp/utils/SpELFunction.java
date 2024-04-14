package io.github.lucklike.springboothttp.utils;

import com.luckyframework.common.StringUtils;
import com.luckyframework.httpclient.proxy.spel.StaticMethodAlias;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/4/14 05:12
 */
public class SpELFunction {

    public static String format(String temp, Object... args) {
        return StringUtils.format(temp, args);
    }

    @StaticMethodAlias("URL")
    public static String urlJoin(String pathPrefix, String pathSuffix) {
        return StringUtils.joinUrlPath(pathPrefix, pathSuffix);
    }

}
