package io.github.lucklike.doccase;

import com.luckyframework.httpclient.proxy.HttpClientProxyObjectFactory;
import com.luckyframework.httpclient.proxy.interceptor.CookieManagerInterceptor;

/**
 * 复杂代理对象生成的工具类
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/17 13:31
 */
public class Lucky {

    private static HttpClientProxyObjectFactory factory;

    static {
        factory = new HttpClientProxyObjectFactory();
    }

    public static <T> T getApi(Class<T> apiClass){
        return factory.getJdkProxyObject(apiClass);
    }
}
