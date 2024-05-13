package io.github.lucky.api;

import com.luckyframework.httpclient.core.ProxyInfo;
import com.luckyframework.httpclient.core.Request;
import com.luckyframework.httpclient.core.Response;
import com.luckyframework.httpclient.core.executor.HttpExecutor;
import com.luckyframework.httpclient.core.executor.JdkHttpExecutor;

import java.net.Proxy;

public class Main2 {

    public static void main(String[] args) {
        // 实例化一个基于JDK的Http执行器
        HttpExecutor executor  = new JdkHttpExecutor();

        // 构建一个请求对象，并设置代理
        Request request = Request.get("http://www.baidu.com")
                .setProxyInfo(
                        new ProxyInfo()
                                .setProxy(Proxy.Type.SOCKS, "203.2.114.116",8112)
                                .setUsername("zaf55368")
                                .setPassword("zaf55368"));

        // 执行器执行http请求并返回一个响应对象
        Response response = executor.execute(request);
        System.out.println(response.getStringResult());
    }
}
