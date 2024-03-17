package io.github.lucklike.doccase;

import com.luckyframework.httpclient.proxy.HttpClientProxyObjectFactory;
import org.junit.Test;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/17 13:17
 */
public class _01_HelloWorldApi_Test {

    private _01_HelloWorldApi api;

    {
        HttpClientProxyObjectFactory factory = new HttpClientProxyObjectFactory();
        api = factory.getJdkProxyObject(_01_HelloWorldApi.class);
    }

    @Test
    public void baiduTest() {
        System.out.println(api.baidu());
    }

    @Test
    public void baidu2Test() {
        System.out.println(api.baidu2());
    }

}
