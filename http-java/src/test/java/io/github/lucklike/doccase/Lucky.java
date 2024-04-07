package io.github.lucklike.doccase;

import com.luckyframework.common.ConfigurationMap;
import com.luckyframework.httpclient.core.executor.HttpClientExecutor;
import com.luckyframework.httpclient.core.executor.OkHttp3Executor;
import com.luckyframework.httpclient.proxy.HttpClientProxyObjectFactory;
import com.luckyframework.httpclient.proxy.creator.Scope;
import com.luckyframework.httpclient.proxy.interceptor.PrintLogInterceptor;

/**
 * 复杂代理对象生成的工具类
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/17 13:31
 */
public class Lucky {

    private static final HttpClientProxyObjectFactory factory;

    static {
        factory = new HttpClientProxyObjectFactory();
        factory.addInterceptor(PrintLogInterceptor.class, Scope.METHOD_CONTEXT, log -> {
            log.setAllowPrintLogBodyMaxLength(1000);
//            log.setReqCondition("false");
//            log.setPrintArgsInfo(true);
//            log.setPrintAnnotationInfo(true);
        });
    }

    public static <T> T getApi(Class<T> apiClass){
        return factory.getJdkProxyObject(apiClass);
    }
}
