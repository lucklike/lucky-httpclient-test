package io.github.lucklike.doccase;

import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.Get;
import com.luckyframework.httpclient.proxy.annotations.PrintLog;

/**
 * SpEL表达式$val$
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/31 00:57
 */
@PrintLog
@DomainName("#{serverBootHttp}")
public interface _09_SpEL_$val$_Api {

    @Get("#{helloApi}")
    String sayHello(String name);
}
