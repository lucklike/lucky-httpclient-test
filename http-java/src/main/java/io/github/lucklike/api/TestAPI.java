package io.github.lucklike.api;

import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.UseProxy;

import java.net.Proxy;
import java.util.concurrent.Future;

public interface TestAPI {


    @Get("http://www.baidu.com")
    @UseProxy(type = Proxy.Type.SOCKS, ip = "118.25.42.139", port = "8882", username = "marry", password = "pass123")
    Future<String> test();

}
