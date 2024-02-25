package io.github.lucklike.api;

import io.github.lucklike.util.Lucky;
import org.junit.Test;

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
    public void indexTest() {
        String indexContent = myApi.index();
        System.out.println(indexContent);
    }

    @Test
    public void sendRequestTest() {
        String indexContent = myApi.sendRequest("Lucky");
        System.out.println(indexContent);
    }
}
