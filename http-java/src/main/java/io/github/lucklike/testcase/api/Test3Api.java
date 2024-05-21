package io.github.lucklike.testcase.api;

import com.luckyframework.httpclient.proxy.HttpClientProxyObjectFactory;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.PrintRequestLog;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/5/22 00:55
 */
@PrintRequestLog(printArgsInfo = true)
public interface Test3Api {

    @Get("http://www.baidu.com#{$this$.addKeyword(keyword)}")
    String baidu2(String keyword);

    default String addKeyword(String keyword) {
        return keyword == null ? "" : "?keyword=" + keyword;
    }
}

class Main {
    public static void main(String[] args) {
        HttpClientProxyObjectFactory factory = new HttpClientProxyObjectFactory();
        Test3Api api = factory.getJdkProxyObject(Test3Api.class);
        api.baidu2(null);
    }
}
