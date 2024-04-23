package io.github.lucklike.serverboot.controller;

import com.google.protobuf.InvalidProtocolBufferException;
import io.github.lucklike.proto.DemoProto;
import io.github.lucklike.resp.Result;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("protobuf")
public class GoogleProtobufTestController {

    @PutMapping("put")
    public void putObject(@RequestBody byte[] bytes) throws InvalidProtocolBufferException {
        DemoProto.Demo demo = DemoProto.Demo.parseFrom(bytes);
        System.out.println(demo);
    }

    @GetMapping("get")
    public void getObject(HttpServletResponse response, String name) throws IOException {
        DemoProto.Demo demo = DemoProto.Demo.newBuilder().setId(1333).setCode("3306").setName(name).build();
        response.setContentType("application/x-protobuf");
        ServletOutputStream outputStream = response.getOutputStream();
        FileCopyUtils.copy(demo.toByteArray(), outputStream);
    }
}
