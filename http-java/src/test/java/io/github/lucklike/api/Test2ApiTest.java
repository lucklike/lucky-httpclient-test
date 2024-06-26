package io.github.lucklike.api;

import io.github.lucklike.testcase.api.Test2Api;
import io.github.lucklike.util.Lucky;
import org.junit.Test;

public class Test2ApiTest {

    private final Test2Api api = Lucky.createApi(Test2Api.class);

    @Test
    public void test() {
        System.out.println(api.test());
    }

    @Test
    public void test2() {
        System.out.println(api.baidu("Hello world"));
    }

    @Test
    public void test3() {
        System.out.println(api.fileDownload());
    }

    @Test
    public void test4() {
        api.baidu2();
    }

}
