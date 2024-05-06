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
    }

    @Test
    void trans2() throws Exception {
        System.out.println(api.trans2("{科室|[0.0]}", true));
    }
}