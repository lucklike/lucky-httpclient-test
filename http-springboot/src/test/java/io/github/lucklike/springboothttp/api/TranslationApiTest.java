package io.github.lucklike.springboothttp.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TranslationApiTest {

    @Resource
    private TranslationApi api;

    @Test
    void trans() throws Exception {
        System.out.println(api.trans("你好，世界！"));
        System.out.println(api.syncTrans("不要回答！不要回答！不要回答！").get());
    }
}