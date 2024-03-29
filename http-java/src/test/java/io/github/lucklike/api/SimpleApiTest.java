package io.github.lucklike.api;

import com.luckyframework.common.StopWatch;
import io.github.lucklike.testcase.api.SimpleApi;
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
        StopWatch sw = new StopWatch();
        sw.start("call");
        System.out.println(api.hi(api.sayHello("八嘎呀路"), api.sayHello("八嘎呀路")));
        sw.stopWatch();
        System.out.println(sw.prettyPrintMillis());
    }

}