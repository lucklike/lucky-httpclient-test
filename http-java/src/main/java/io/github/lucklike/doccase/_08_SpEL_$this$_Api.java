package io.github.lucklike.doccase;

import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.Get;

/**
 * SpEL表达式$this$
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/31 00:45
 */
@DomainName("#{$this$.getSearchAddress()}")
public interface _08_SpEL_$this$_Api {

    @Get
    String index();


    default String getSearchAddress() {
        String[] address = {
                "http://www.baidu.com",
                "https://www.bing.com",
                "https://www.google.com",
        };
        return address[(int)(Math.random() * address.length)];
    }
}
