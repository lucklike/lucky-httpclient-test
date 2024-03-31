package io.github.lucklike.doccase;

import com.luckyframework.httpclient.proxy.HttpClientProxyObjectFactory;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/31 16:18
 */
public class _09_SpEL_$val$_ApiTest {

    private final  _09_SpEL_$val$_Api api;

    {
        HttpClientProxyObjectFactory factory = new HttpClientProxyObjectFactory();
        factory.addExpressionParam("serverBootHttp", "http://localhost:8081");
        factory.addExpressionParam("helloApi", "/query/sayHello");

        api = factory.getJdkProxyObject(_09_SpEL_$val$_Api.class);
    }

    @Test
    public void sayHello() {
        api.sayHello("空调遥控器");
    }
}