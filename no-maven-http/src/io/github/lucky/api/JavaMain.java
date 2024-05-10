package io.github.lucky.api;

import com.luckyframework.httpclient.proxy.HttpClientProxyObjectFactory;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.UseProxy;
import com.luckyframework.httpclient.proxy.creator.Scope;
import com.luckyframework.httpclient.proxy.interceptor.PrintLogInterceptor;

import java.net.Proxy;

public class JavaMain {

    // 初始化代理对象工厂
    static HttpClientProxyObjectFactory factory = new HttpClientProxyObjectFactory();

    static {

        // 添加日志拦截器
        factory.addInterceptor(PrintLogInterceptor.class, Scope.METHOD_CONTEXT, i -> {

            // 设置日志中允许打印的最大请求体长度
            i.setAllowPrintLogBodyMaxLength(2000);
        });
    }

    public static void main(String[] args) {
        // 获取基于JDK实现的代理对象
        BaiDuApi api = factory.getJdkProxyObject(BaiDuApi.class);
        // 执行HTTP方法
        System.out.println(api.index());
    }

    interface BaiDuApi {

        @UseProxy(
                type = Proxy.Type.SOCKS,
                ip = "203.2.114.116",
                port = "8112",
                username = "zaf55368",
                password = "zaf55368")
        @Get("http://www.baidu.com")
        String index();
    }
}
