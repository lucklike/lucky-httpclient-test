package io.github.lucklike.api;

import io.github.lucklike.testcase.api.TranslationApi;
import io.github.lucklike.util.Lucky;
import org.junit.Test;

/**
 * @author fukang
 * @version 1.0.0
 * @date 2024/3/17 23:34
 */
public class TranslationApiTest {

    private final TranslationApi api = Lucky.createApi(TranslationApi.class);

    @Test
    public void test() {
        System.out.println(api.trans("一切都是有尽头的。"));
    }

}
