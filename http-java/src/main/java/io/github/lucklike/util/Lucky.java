package io.github.lucklike.util;

import com.luckyframework.common.ConfigurationMap;
import com.luckyframework.httpclient.core.ProtobufAutoConvert;
import com.luckyframework.httpclient.core.Response;
import com.luckyframework.httpclient.core.executor.HttpClientExecutor;
import com.luckyframework.httpclient.core.executor.JdkHttpExecutor;
import com.luckyframework.httpclient.core.executor.OkHttp3Executor;
import com.luckyframework.httpclient.core.executor.OkHttpExecutor;
import com.luckyframework.httpclient.core.ssl.SSLUtils;
import com.luckyframework.httpclient.core.ssl.TrustAllHostnameVerifier;
import com.luckyframework.httpclient.proxy.HttpClientProxyObjectFactory;
import com.luckyframework.httpclient.proxy.creator.Scope;
import com.luckyframework.httpclient.proxy.interceptor.CookieManagerInterceptor;
import com.luckyframework.httpclient.proxy.interceptor.PrintLogInterceptor;
import com.luckyframework.reflect.ClassUtils;
import com.luckyframework.reflect.MethodUtils;
import io.github.lucklike.spel.function.SpELFunction;
import io.github.lucklike.testcase.api.FanYiGouApi;

import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedTrustManager;
import java.lang.reflect.Method;
import java.net.Socket;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

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
//            log.setReqCondition("false");
//            log.setPrintArgsInfo(true);
//            log.setPrintAnnotationInfo(true);
        });
//        factory.addInterceptor(CookieManagerInterceptor.class, Scope.SINGLETON, 100);
        factory.addSpringElRootVariable("serverBoot", "http://localhost:8081");
        factory.addSpringElRootVariable("bootHttps", "https://localhost:443");
//        factory.addHeader("Accept-Encoding", "gzip, deflate, br, zstd");
        factory.setHttpExecutor(new OkHttp3Executor());
        Response.addAutoConvert(new ProtobufAutoConvert());
        factory.addSpringElFunctionClass(SpELFunction.class);

//        factory.addSpringElFunctionClass(FanYiGouApi.class);

//        factory.setHostnameVerifier(TrustAllHostnameVerifier.DEFAULT_INSTANCE);
//
//        try {
//            factory.setSslSocketFactory(SSLUtils.createIgnoreVerifySSL("TLS").getSocketFactory());
//        }catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    public static <T> T createApi(Class<T> apiClass) {
        return factory.getJdkProxyObject(apiClass);
    }


}
