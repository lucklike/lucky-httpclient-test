package io.github.lucklike.springboothttp.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class FileAPITest {

    @Resource
    private FileAPI fileAPI;

    @Test
    void uploadTest() {
        System.out.println(fileAPI.upload("file:/Users/fukang/Pictures/*.*"));
    }
}
