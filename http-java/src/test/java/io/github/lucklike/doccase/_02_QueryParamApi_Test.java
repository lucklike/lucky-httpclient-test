package io.github.lucklike.doccase;

import org.junit.Test;

/**
 * Query参数的使用
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/17 13:27
 */
public class _02_QueryParamApi_Test {

    private final _02_QueryParamApi api = Lucky.getApi(_02_QueryParamApi.class);

    @Test
    public void sayHelloTest() {
        System.out.println(api.sayHello("error"));
    }

    @Test
    public void sayHello1Test() {
        System.out.println(api.sayHello1("小黑子"));
    }

}
