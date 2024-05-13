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
        System.out.println(api.trans2("{Department [wettable facial tissue-natural without fragrance]}", false).get());
    }

    @Test
    void trans3() throws Exception {
        System.out.println(api.ttt("a94edf938ecd3a2a8ca013bd800b52ad", "b2482869665723323117ea6d00de9818833788eecce62cbfe88f6baeb23eb08ef59031af1aece287fe54e8b6c383eb3f"));
    }
}