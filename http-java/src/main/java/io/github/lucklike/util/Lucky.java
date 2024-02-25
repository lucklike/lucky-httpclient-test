package io.github.lucklike.util;

import com.luckyframework.httpclient.core.executor.HttpClientExecutor;
import com.luckyframework.httpclient.core.executor.OkHttp3Executor;
import com.luckyframework.httpclient.proxy.HttpClientProxyObjectFactory;
import com.luckyframework.httpclient.proxy.creator.Scope;
import com.luckyframework.httpclient.proxy.interceptor.PrintLogInterceptor;

/**
 * 工具类
 * @author fukang
 * @version 1.0.0
 * @date 2024/2/24 23:03
 */
public abstract class Lucky {

    private final static HttpClientProxyObjectFactory factory = new HttpClientProxyObjectFactory();
    static {
        factory.addInterceptor(PrintLogInterceptor.class, Scope.METHOD_CONTEXT, log -> {
            log.setAllowPrintLogBodyMaxLength(1000);
            log.setRespCondition("false");
        });
        HttpClientProxyObjectFactory.addExpressionParam("serverBoot", "http://localhost:8081");
    }

    public static <T> T createApi(Class<T> apiClass) {
        return factory.getJdkProxyObject(apiClass);
    }
}
