package io.github.lucklike.api;

import com.luckyframework.httpclient.core.RequestMethod;
import io.github.lucklike.util.Lucky;
import junit.framework.TestCase;

/**
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/2/24 23:26
 */
public class DomainURLMethodConfigApiTest extends TestCase {

    private final DomainURLMethodConfigApi api2 = Lucky.createApi(DomainURLMethodConfigApi.class);

    public void testCall() {
//        String r1 = api2.call("hi/马保国MC", "post");
//        System.out.println(r1);
        String r2 = api2.call("sayHello?name=Tom", RequestMethod.GET);
        System.out.println(r2);
    }
}