package io.github.lucklike.springboothttp.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

@SpringBootTest
class AddApiTest {

    @Resource
    private AddApi api;

    @Test
    void getData() {
        for (int i = 0; i < 3; i++) {
            System.out.println(api.getData(Arrays.asList("hello", "world")));
        }
    }

    @Test
    void test1() throws InterruptedException, ExecutionException {

        api.getUser().get();
        api.getData1().get();


    }

}