package io.github.lucklike.springboothttp;

import com.luckyframework.httpclient.core.BodyObject;
import io.github.lucklike.springboothttp.api.BinaryDataAPI;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@SpringBootTest
class SpringbootHttpApplicationTests {

    @Resource
    private BinaryDataAPI binaryDataAPI;

    @Test
    void contextLoads() throws IOException {
        binaryDataAPI.upload(BodyObject.byteBody(new File("C:\\Users\\18143\\Pictures\\Screenshots\\屏幕截图 2024-01-16 094607.png")));
    }

}
