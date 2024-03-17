package io.github.lucklike.testcase.api;

import com.luckyframework.httpclient.core.RequestMethod;
import com.luckyframework.httpclient.proxy.HttpClientProxyObjectFactory;
import com.luckyframework.httpclient.proxy.annotations.DomainName;
import com.luckyframework.httpclient.proxy.annotations.HttpRequest;
import com.luckyframework.httpclient.proxy.annotations.MethodParam;
import com.luckyframework.httpclient.proxy.annotations.Url;
import io.github.lucklike.util.Lucky;

import java.util.Map;

/**
 * 域名配置->SpEL写法
 * <pre>
 *  在SpEL表达式中可以通过<b>$val$</b>来引用由
 *      1.{@link HttpClientProxyObjectFactory#addExpressionParam(String, Object)}
 *      2.{@link HttpClientProxyObjectFactory#addExpressionParams(Map)}
 *  导入的参数
 * </pre>
 *
 * @see Lucky
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/2/24 23:00
 */
@DomainName("#{$val$.serverBoot}/simple/")
public interface DomainURLMethodConfigApi {

    /**
     * 使用指定的方法调用一个指定的URL
     * <pre>
     *     {@link Url}注解用于标注该参数为一个URL参数
     *     {@link MethodParam}注解用于标注该参数为一个请求方式指定参数
     *     eg:
     *      url=hi/马保国MC, method=post
     *          ->
     *      POST http://localhost:8081/simple/hi/马保国MC
     *
     *      url=sayHello?name=Tom，method=get
     *          ->
     *      GET http://localhost:8081/simple/sayHello?name=Tom
     *
     * </pre>
     *
     * @param url    要调用的URL信息
     * @param method 使用的调用方式
     * @return
     */
    @HttpRequest
    String call(@Url String url, @MethodParam String method);

    @HttpRequest
    String call(@Url String url, @MethodParam RequestMethod method);
}
