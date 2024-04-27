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
//        System.out.println(api.ttt(" a94edf938ecd3a2a8ca013bd800b52ad", "b482869665723323117ea6d00de9818833788eecce62cbfe88f6baeb23eb08ef59031af1aece287fe54e8b6c383eb3f"));
    }
}