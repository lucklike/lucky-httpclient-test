package io.github.lucklike.api;

import io.github.lucklike.util.Lucky;
import junit.framework.TestCase;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/2/24 23:02
 */
public class SimpleApiTest extends TestCase {

    private final SimpleApi api = Lucky.createApi(SimpleApi.class);

    public void testSayHello() {
        System.out.println(api.sayHello("Jack&age=19"));
        System.out.println(api.sayHello("蔡徐坤"));
    }

    public void testHi() {
        System.out.println(api.hi("Tom"));
        System.out.println(api.hi("爱因斯坦"));
    }

}