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

    private _02_QueryParamApi api = Lucky.getApi(_02_QueryParamApi.class);

    @Test
    public void baiduQueryTest() {
        System.out.println(api.baiduQuery("lucky-httpclient"));
    }

    @Test
    public void baiduQuery2Test() {
        api.baiduQuery("lucky-httpclient");
        System.out.println(api.baiduQuery2("lucky-httpclient"));
    }

}
