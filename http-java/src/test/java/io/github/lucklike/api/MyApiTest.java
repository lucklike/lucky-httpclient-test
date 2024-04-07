package io.github.lucklike.api;

import io.github.lucklike.testcase.api.MyApi;
import io.github.lucklike.util.Lucky;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * {@link MyApi}的测试类
 *
 * @author fukang
 * @version 1.0.0
 * @date 2024/2/24 15:49
 */
public class MyApiTest {
    private final MyApi myApi = Lucky.createApi(MyApi.class);

    @Test
    public void indexTest() throws ExecutionException, InterruptedException {
        String indexContent = myApi.index().get();
        System.out.println(indexContent);
    }

    @Test
    public void sendRequestTest() {
        String indexContent = myApi.sendRequest("Lucky");
        System.out.println(indexContent);
    }
}
