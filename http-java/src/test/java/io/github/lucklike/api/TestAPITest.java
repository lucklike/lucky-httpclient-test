package io.github.lucklike.api;

import com.luckyframework.httpclient.core.Response;
import io.github.lucklike.util.Lucky;
import org.junit.Test;

public class TestAPITest {

    private TestAPI api = Lucky.createApi(TestAPI.class);

    @Test
    public void test1() {
        Response response = api.test();
        System.out.println(response.getStringResult());
    }

}
