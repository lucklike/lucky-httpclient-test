package io.github.lucklike.springboothttp.api;

import com.luckyframework.common.NanoIdUtils;
import com.luckyframework.reflect.ClassUtils;
import io.github.lucklike.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ResolvableType;

import javax.annotation.Resource;

@SpringBootTest
public class JavaSerializableAPI2Test {

    @Resource
    private JavaSerializableAPI2 api;

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
