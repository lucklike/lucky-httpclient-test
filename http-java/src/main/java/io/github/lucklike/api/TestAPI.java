package io.github.lucklike.api;

import com.luckyframework.httpclient.core.Response;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.Proxy;
import com.luckyframework.httpclient.proxy.annotations.StaticHeader;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public interface TestAPI {



    @Get("http://www.baidu.com")
    @StaticHeader("Authorization=#{$this$.base64()}")
    @Proxy(type = java.net.Proxy.Type.SOCKS, ip = "118.25.42.139", port = "8882")
    Response test();


    default String base64() {
        String auth = "marry:pass123";
        byte[] encodeAuth = Base64.getEncoder().encode(auth.getBytes());
        return "Basic " + new String(encodeAuth, StandardCharsets.ISO_8859_1);
    }
}
