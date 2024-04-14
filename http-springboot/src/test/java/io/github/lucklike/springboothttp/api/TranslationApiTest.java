package io.github.lucklike.springboothttp.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TranslationApiTest {

    @Resource
    private TranslationApi api;

    @Test
    void trans() {
        System.out.println(api.trans("你好，世界！"));
        System.out.println(api.trans("你好，世界！"));
    }
}