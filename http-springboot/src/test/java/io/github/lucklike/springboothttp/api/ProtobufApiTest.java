package io.github.lucklike.springboothttp.api;

import io.github.lucklike.proto.DemoProto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ProtobufApiTest {

    @Resource
    ProtobufApi api;

    @Test
    void put() {
        DemoProto.Demo demo = DemoProto.Demo.newBuilder()
                .setId(123)
                .setCode("9527")
                .setName("中文测试-Hello World")
                .build();

        api.put(demo);
    }

    @Test
    void get() {

        System.out.println(api.get("Jack-慷慨"));
    }
}