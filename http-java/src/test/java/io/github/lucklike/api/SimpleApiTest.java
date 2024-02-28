package io.github.lucklike.api;

import io.github.lucklike.util.Lucky;
import junit.framework.TestCase;

import java.util.concurrent.ExecutionException;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/2/24 23:02
 */
public class SimpleApiTest extends TestCase {

    private final SimpleApi api = Lucky.createApi(SimpleApi.class);

    public void testSayHello() throws ExecutionException, InterruptedException {
        System.out.println(api.sayHello("Jack&age=19").get());
        System.out.println(api.sayHello("蔡徐坤").get());
    }

    public void testHi() {
        System.out.println(api.hi("Tom"));
        System.out.println(api.hi("爱因斯坦"));
    }

}