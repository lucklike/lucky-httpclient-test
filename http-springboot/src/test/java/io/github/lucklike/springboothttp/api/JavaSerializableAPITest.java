package io.github.lucklike.springboothttp.api;

import com.luckyframework.common.NanoIdUtils;
import com.luckyframework.httpclient.core.Request;
import io.github.lucklike.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class JavaSerializableAPITest {

    @Resource
    private JavaSerializableAPI api;

    @Test
    void getObjectTest() {
        System.out.println(api.getObject());
    }

    @Test
    void putObjectTest() {
        User user = api.getObject();
        user.setUsername(NanoIdUtils.randomNanoId());
        System.out.println(api.putObject(user));
    }

    @Test
    void testTest() {
        api.test();
    }
}
