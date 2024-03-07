package io.github.lucklike.api;

import com.luckyframework.httpclient.core.Header;
import com.luckyframework.httpclient.core.Response;
import com.luckyframework.httpclient.core.ResponseCookie;
import com.luckyframework.httpclient.proxy.interceptor.CookieManagerInterceptor;
import io.github.lucklike.util.Lucky;
import junit.framework.TestCase;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/2 22:12
 */
public class AuthAPITest extends TestCase {

    private final AuthAPI authAPI = Lucky.createApi(AuthAPI.class);

    public void testGetToken() {
    }

    public void testHello() throws InterruptedException {
        while (true) {
            System.out.println(authAPI.hello());
            Thread.sleep(5000L);
        }
    }

    public void testGetToken2() {
        Response resp = authAPI.getToken2("Jack");
        for (Header cookieHeader : resp.getCookies()) {
            ResponseCookie cookie = new ResponseCookie(cookieHeader, resp);
            System.out.println(cookie);
        }
    }
}